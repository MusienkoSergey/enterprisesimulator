package ua.ck.codenvy.simulator.entity;

import java.util.List;

/**
 * Created by sergey on 16.03.14.
 */
public class Company {

    private static Company instance = null;
    private List<Employee> employees;

    private Company() { }

    public static Company getInstance() {
        if(instance == null){
            instance = new Company();
        }
        return instance;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
