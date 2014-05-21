package ua.ck.codenvy.simulator.entity;

import com.google.inject.Inject;
import ua.ck.codenvy.simulator.client.Employee;
import ua.ck.codenvy.simulator.generator.Generator;

import java.util.List;

/**
 * Created by sergey on 16.03.14.
 */
public class Company {

    private static Company instance = null;

    @Inject
    private Generator generator;

    private List<Employee> employees;

    @Inject
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

    public void hireEmployeesToWork(){
        setEmployees(generator.start());
    }

}
