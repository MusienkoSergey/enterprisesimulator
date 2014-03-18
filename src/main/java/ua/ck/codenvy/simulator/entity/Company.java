package ua.ck.codenvy.simulator.entity;

import java.util.List;

/**
 * Created by sergey on 16.03.14.
 */
public class Company {

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
