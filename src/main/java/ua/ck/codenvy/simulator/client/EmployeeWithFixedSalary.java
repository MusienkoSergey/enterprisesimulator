package ua.ck.codenvy.simulator.client;


import ua.ck.codenvy.simulator.client.Employee;

/**
 * Created by sergey on 16.03.14.
 */

public class EmployeeWithFixedSalary extends Employee {
    public double solveSalary(double salary) {
        setSalary(salary);
        return salary;
    }
}
