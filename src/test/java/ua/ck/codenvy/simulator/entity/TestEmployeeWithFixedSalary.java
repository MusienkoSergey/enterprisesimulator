package ua.ck.codenvy.simulator.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by sergey on 23.03.14.
 */
public class TestEmployeeWithFixedSalary {

    @Test
    public void testSolveSalary() {
        EmployeeWithFixedSalary employeeWFS = new EmployeeWithFixedSalary();
        employeeWFS.solveSalary(10.5);
        assertEquals(employeeWFS.getSalary(), 10.5, 0.1E-15);
    }
}
