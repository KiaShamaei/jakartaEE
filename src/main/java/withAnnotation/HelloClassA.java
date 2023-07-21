package withAnnotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/annotation")
public class HelloClassA extends HttpServlet {
    private String testContext ;
    @Override
    public void init(ServletConfig servletConfig){
        this.testContext = servletConfig.getServletContext().getInitParameter("url");
    }
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        var param = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("this is writer from set query String :  " + param +" url : " + testContext );
    }
}
