package ua.ck.codenvy.simulator.servlet;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;
import ua.ck.codenvy.simulator.entity.Company;
import ua.ck.codenvy.simulator.client.Employee;
import ua.ck.codenvy.simulator.generator.GeneratorModuleOne;
import ua.ck.codenvy.simulator.generator.GeneratorModuleTwo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sergey on 15.04.14.
 */
public class GeneratorServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        if(req.getParameter("submit") != null) {
            if(req.getParameter("submit").equals("Start generator 1")) {
                StartGenerator(new GeneratorModuleOne(), req);
                req.getSession().setAttribute("Message", "Generated up to ten employees");
            } else if (req.getParameter("submit").equals("Start generator 2")) {
                StartGenerator(new GeneratorModuleTwo(), req);
                req.getSession().setAttribute("Message", "Generated up to five employees");
            } else {
                req.getSession().setAttribute("Message", "Generated null employees");
            }
        }

        req.getRequestDispatcher("/generator.jsp").include(req, resp);
    }

    private void StartGenerator(AbstractModule module, HttpServletRequest req) {
        Company company;
        Injector injector = Guice.createInjector(module);
        company = injector.getInstance(Company.class);

        company.hireEmployeesToWork();

        CompanyDaoJDBC companyDaoGDBC = new CompanyDaoJDBC();
        companyDaoGDBC.deleteAllEmployee();

        for (Employee employee: company.getEmployees()) {
            companyDaoGDBC.addEmployee(employee);
        }
        req.getSession().setAttribute("AllEmployees", companyDaoGDBC.getAllEmployee());

    }
}
