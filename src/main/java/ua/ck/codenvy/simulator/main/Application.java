package ua.ck.codenvy.simulator.main;

import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;
import ua.ck.codenvy.simulator.entity.Company;
import ua.ck.codenvy.simulator.entity.Employee;
import ua.ck.codenvy.simulator.generator.Generator;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by sergey on 17.03.14.
 */
public class Application {
    public static void main (String[] args) throws SQLException {

        List<Employee> employees;
        List<Employee> employees1;

        Company company = new Company();
        Generator generator = new Generator();
        CompanyDaoJDBC companyDaoGDBC = new CompanyDaoJDBC();
        companyDaoGDBC.deleteAllEmployee();

        company.setEmployees(generator.start());

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