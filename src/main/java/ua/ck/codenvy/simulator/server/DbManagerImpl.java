package ua.ck.codenvy.simulator.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ua.ck.codenvy.simulator.client.DbManager;
import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;
import ua.ck.codenvy.simulator.client.Employee;

import java.util.List;

/**
 * Created by sergey on 29.04.14.
 */
public class DbManagerImpl extends RemoteServiceServlet implements DbManager{

    CompanyDaoJDBC company;
    @Override
    public List<Employee> getAllEmployees() {
        company = new CompanyDaoJDBC();
        return company.getAllEmployee();
    }

    @Override
    public void removeEmployees(long id){
        company = new CompanyDaoJDBC();
        company.deleteEmployeeForId(id);
    }

}
