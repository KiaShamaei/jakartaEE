package withXmlConfig;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloClass implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet container start");
        System.out.println(servletConfig.getInitParameter("user"));
        System.out.println(servletConfig.getServletContext().getInitParameter("url"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello world! test </h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
