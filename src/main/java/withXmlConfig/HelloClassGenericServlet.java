package withXmlConfig;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloClassGenericServlet extends GenericServlet {
    private String context;
    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Hello world! test : "+this.context + "</h1>");

    }
    @Override
    public void init(ServletConfig servletConfig){
       var testContext =  servletConfig.getServletContext().getInitParameter("url");
       this.context = testContext;
        System.out.println("this is from init " + testContext);
    }
}
