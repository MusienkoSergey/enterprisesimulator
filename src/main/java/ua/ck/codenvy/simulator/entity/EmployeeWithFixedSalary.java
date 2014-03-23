package ua.ck.codenvy.simulator.entity;

import javax.persistence.*;

/**
 * Created by sergey on 16.03.14.
 */
@Entity
@Table(name = "Employee")
public class EmployeeWithFixedSalary extends Employee {
    public double solveSalary(double salary) {
        setSalary(salary);
        return salary;
    }
}
