package ua.ck.codenvy.simulator.entity;

import com.google.inject.Inject;
import ua.ck.codenvy.simulator.generator.Generator;
import ua.ck.codenvy.simulator.shared.Employee;

import java.util.List;

/**
 * Created by sergey on 16.03.14.
 */
public class Company {

    private static Company instance = null;

    private List<Employee> employees;

    @Inject
    private Generator generator;

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
