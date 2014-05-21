package ua.ck.codenvy.simulator.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ua.ck.codenvy.simulator.client.CreatorGenerator;
import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;
import ua.ck.codenvy.simulator.entity.Company;
import ua.ck.codenvy.simulator.client.Employee;
import ua.ck.codenvy.simulator.generator.GeneratorModuleOne;
import ua.ck.codenvy.simulator.generator.GeneratorModuleTwo;

/**
 * Created by sergey on 28.04.14.
 */
public class CreatorGeneratorImpl extends RemoteServiceServlet implements CreatorGenerator {

    Company company;
    @Override
    public String choiceOfGenerator(int type) {
        String message;
        if(type == 1) {
            startGenerator(new GeneratorModuleOne());
            message = "Generated up to ten employees";
        } else if (type == 2) {
            startGenerator(new GeneratorModuleTwo());
            message = "Generated up to five employees";
        } else {
            message = "Generated null employees";
        }
        return message;
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
