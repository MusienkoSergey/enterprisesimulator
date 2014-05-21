package ua.ck.codenvy.simulator.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;
import ua.ck.codenvy.simulator.entity.Company;
import ua.ck.codenvy.simulator.client.Employee;
import ua.ck.codenvy.simulator.generator.GeneratorModuleTwo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sergey on 17.03.14.
 */
public class Application {
    public static void main (String[] args) throws SQLException {

        List<Employee> employees;
        List<Employee> employees1;
        Company company = null;

        //company = Company.getInstance();

        Injector injector = Guice.createInjector(new GeneratorModuleTwo());
        company = injector.getInstance(Company.class);

        company.hireEmployeesToWork();

        CompanyDaoJDBC companyDaoGDBC = new CompanyDaoJDBC();
        companyDaoGDBC.deleteAllEmployee();



        for (Employee employee: company.getEmployees()) {
            companyDaoGDBC.addEmployee(employee);
        }

        employees = companyDaoGDBC.getAllEmployee();


        for (Employee employee: employees) {
            System.out.println("Id " + employee.getId());
            System.out.println("Surname " + employee.getSurname());
            System.out.println("DateOfBirth " + employee.getDateOfBirth());
            System.out.println("Salary " + employee.getSalary());
        }

        System.out.println("\nОтсортировано по зарплате\n");

        employees1 = companyDaoGDBC.sortingBySalary();

        for (Employee employee: employees1) {
            System.out.println("Id " + employee.getId());
            System.out.println("Surname " + employee.getSurname());
            System.out.println("DateOfBirth " + employee.getDateOfBirth());
            System.out.println("Salary " + employee.getSalary());
        }

    }
}