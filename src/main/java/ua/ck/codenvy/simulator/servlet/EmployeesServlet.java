package ua.ck.codenvy.simulator.servlet;

import ua.ck.codenvy.simulator.dao.CompanyDaoJDBC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sergey on 15.04.14.
 */
public class EmployeesServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("AllEmployees") == null){
            CompanyDaoJDBC company = new CompanyDaoJDBC();
            req.getSession().setAttribute("AllEmployees", company.getAllEmployee());
        }
        resp.setContentType("text/html;charset=utf-8");

        CompanyDaoJDBC companyDaoGDBC = new CompanyDaoJDBC();

        if(req.getParameter("sorting") != null) {
            if(req.getParameter("sorting").equals("Sorting By Surname")) {
                req.getSession().setAttribute("AllEmployees", companyDaoGDBC.sortingBySurname());
            } else if (req.getParameter("sorting").equals("Sorting By Date Of Birth")) {
                req.getSession().setAttribute("AllEmployees", companyDaoGDBC.sortingByDateOfBirth());
            } else if (req.getParameter("sorting").equals("Sorting By Salary")) {
                req.getSession().setAttribute("AllEmployees", companyDaoGDBC.sortingBySalary());           }
        }
        req.getRequestDispatcher("/employees.jsp").include(req, resp);

    }
}
