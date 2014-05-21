package ua.ck.codenvy.simulator.rest;

import ua.ck.codenvy.simulator.client.ClientEmployee;
import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;
import ua.ck.codenvy.simulator.shared.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
* Created by sergey on 12.05.14.
*/
@Path("/manager")
public class DbManager {

    private CompanyDaoJDBC companyDaoJDBC;
    private List<Employee> allEmployees;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientEmployee> getAllEmployees() {

        companyDaoJDBC = new CompanyDaoJDBC();
        return writeClientEmployees(companyDaoJDBC.getAllEmployee());
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void removeEmployees(@QueryParam("id") String id) {
        companyDaoJDBC = new CompanyDaoJDBC();
        companyDaoJDBC.deleteEmployeeForId(Long.parseLong(id));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClientEmployee> sortingEmployees(@QueryParam("buttonName") String buttonName) {
        companyDaoJDBC = new CompanyDaoJDBC();

        if(buttonName.equals("Surname")) {
            return writeClientEmployees(companyDaoJDBC.sortingBySurname());
        } else  if(buttonName.equals("Data of Birth")) {
            return writeClientEmployees(companyDaoJDBC.sortingByDateOfBirth());
        } else if(buttonName.equals("Salary")) {
            return writeClientEmployees(companyDaoJDBC.sortingBySalary());
        } else {
            return writeClientEmployees(companyDaoJDBC.getAllEmployee());
        }
    }

    private List<ClientEmployee> writeClientEmployees(List<Employee> allEmployees) {
        List<ClientEmployee> clientEmployees = new ArrayList<>();
        for(Employee employee: allEmployees) {
            ClientEmployee clientEmployee = new ClientEmployee();
            clientEmployee.setId(employee.getId());
            clientEmployee.setSalary(employee.getSalary());
            clientEmployee.setDateOfBirth(employee.getDateOfBirth().toString());
            clientEmployee.setSurname(employee.getSurname());
            clientEmployees.add(clientEmployee);
        }
        return clientEmployees;
    }
}