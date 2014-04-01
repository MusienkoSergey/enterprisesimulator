package ua.ck.codenvy.simulator.entity;

/**
 * Created by sergey on 01.04.14.
 */
import ua.ck.codenvy.simulator.entity.*;

public class EmployeeFactory {

    public Employee CreateEmployee(TypeEmployee typeEmployee) {

        if (typeEmployee == TypeEmployee.EMPLOYEE_WITH_FIXED_SALARY) {
            return new EmployeeWithFixedSalary();
        } else {
            return new EmployeeWithHourlyWages();
        }
    }
}
