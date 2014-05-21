package ua.ck.codenvy.simulator.rest;//package ua.ck.codenvy.simulator.rest;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;
import ua.ck.codenvy.simulator.entity.Company;
import ua.ck.codenvy.simulator.generator.GeneratorModuleOne;
import ua.ck.codenvy.simulator.generator.GeneratorModuleTwo;
import ua.ck.codenvy.simulator.shared.Employee;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
* Created by sergey on 12.05.14.
*/
@Path("/generator")
public class CreatorGenerator  {
    private Company company;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void choiceOfGenerator(@QueryParam("type") String type) {

        String message;
        if(type.equals("One")) {
            startGenerator(new GeneratorModuleOne());
//            message = "Generated up to ten employees";
        } else if(type.equals("Two")) {
            startGenerator(new GeneratorModuleTwo());
//            message = "Generated up to five employees";
        } else {
            message = "Generated null employees";
        }

    }

    private void startGenerator (AbstractModule module) {

        Injector injector = Guice.createInjector(module);
        company = injector.getInstance(Company.class);

        company.hireEmployeesToWork();

        CompanyDaoJDBC companyDaoGDBC = new CompanyDaoJDBC();
        companyDaoGDBC.deleteAllEmployee();

        for (Employee employee: company.getEmployees()) {
            companyDaoGDBC.addEmployee(employee);
        }
    }
}
