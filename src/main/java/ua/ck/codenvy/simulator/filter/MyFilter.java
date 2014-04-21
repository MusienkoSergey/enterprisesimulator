package ua.ck.codenvy.simulator.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * Created by sergey on 20.04.14.
 */
public class MyFilter implements Filter {

    private Counter counter;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { counter = new Counter(); }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        counter.inc();
        HttpServletRequestWrapper filteredRequest = new HttpServletRequestWrapper((HttpServletRequest)servletRequest);
        filteredRequest.getSession().setAttribute("Counter", counter.get());
        filterChain.doFilter(filteredRequest.getRequest(), servletResponse);
    }

    @Override
    public void destroy() {

    }

}
