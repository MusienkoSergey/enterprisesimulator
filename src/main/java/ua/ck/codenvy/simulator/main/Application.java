package ua.ck.codenvy.simulator.main;

import ua.ck.codenvy.simulator.dao.Factory;
import ua.ck.codenvy.simulator.entity.Company;
import ua.ck.codenvy.simulator.entity.Employee;
import ua.ck.codenvy.simulator.generator.Generator;
import ua.ck.codenvy.simulator.util.HibernateUtil;

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

        company.setEmployees(generator.start());
        Factory.getInstance().getCompanyDao().deleteAllEmployee();

        for (Employee employee: company.getEmployees()) {
            Factory.getInstance().getCompanyDao().addEmployee(employee);
        }

        employees = Factory.getInstance().getCompanyDao().getAllEmployee();
        employees1 = Factory.getInstance().getCompanyDao().sortingBySalary();

        for (Employee employee: employees) {
            System.out.println("Id " + employee.getId());
            System.out.println("Surname " + employee.getSurname());
            System.out.println("DateOfBirth " + employee.getDateOfBirth());
            System.out.println("Salary " + employee.getSalary());
        }

        System.out.println("\nОтсортировано по зарплате\n");

        for (Employee employee: employees1) {
            System.out.println("Id " + employee.getId());
            System.out.println("Surname " + employee.getSurname());
            System.out.println("DateOfBirth " + employee.getDateOfBirth());
            System.out.println("Salary " + employee.getSalary());
        }

        HibernateUtil.stopConnectionProvider();
    }
}