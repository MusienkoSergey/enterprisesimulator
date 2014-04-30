package ua.ck.codenvy.simulator.entity;

import org.junit.Test;
import ua.ck.codenvy.simulator.client.EmployeeWithHourlyWages;

import static org.junit.Assert.*;

/**
 * Created by sergey on 23.03.14.
 */
public class TestEmployeeWithHourlyWages {

    @Test
    public void testSolveSalary() {
        EmployeeWithHourlyWages employeeWHW = new EmployeeWithHourlyWages();
        employeeWHW.solveSalary(10.5);
        double result = 8*8*10.5;
        assertEquals(employeeWHW.solveSalary(10.5), result, 0.1E-15);
    }

}
