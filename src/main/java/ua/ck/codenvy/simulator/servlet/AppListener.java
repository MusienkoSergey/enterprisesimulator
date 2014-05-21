package ua.ck.codenvy.simulator.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sergey on 21.04.14.
 */
public class AppListener implements ServletContextListener, HttpSessionListener {

   @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("getServerInfo", servletContextEvent.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("http Session created " + date());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("http Session destroyed " + date());
    }

    private String date(){
        Date d1 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm");
        return df.format(d1);
    }
}
