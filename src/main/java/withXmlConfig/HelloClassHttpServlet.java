package withXmlConfig;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloClassHttpServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        var param = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("this is writer from set query String :  " + param);
    }
}
