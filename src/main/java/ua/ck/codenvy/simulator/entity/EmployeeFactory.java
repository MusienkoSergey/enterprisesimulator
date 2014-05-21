package ua.ck.codenvy.simulator.entity;

import ua.ck.codenvy.simulator.shared.Employee;
import ua.ck.codenvy.simulator.shared.EmployeeWithFixedSalary;
import ua.ck.codenvy.simulator.shared.EmployeeWithHourlyWages;

/**
 * Created by sergey on 01.04.14.
 */

public class EmployeeFactory {

    public Employee CreateEmployee(TypeEmployee typeEmployee) {

        if (typeEmployee == TypeEmployee.EMPLOYEE_WITH_FIXED_SALARY) {
            return new EmployeeWithFixedSalary();
        } else {
            return new EmployeeWithHourlyWages();
        }
    }
}
