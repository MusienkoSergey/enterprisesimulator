package ua.ck.codenvy.simulator.shared;


/**
 * Created by sergey on 16.03.14.
 */

public class EmployeeWithHourlyWages extends Employee {
    public double solveSalary(double hours) {
        double result = 8*8*hours;
        setSalary(result);
        return result;
    }
}
