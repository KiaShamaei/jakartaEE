package withXmlConfig;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/asyncServlet")
public class AsyncSendServlet extends HttpServlet {
    @Override
    protected  void  service (HttpServletRequest req , HttpServletResponse res) throws IOException {
        String number = req.getParameter("number");
        res.setContentType("text/plain");
        res.setHeader("Cache_Control" , "no-cache");
        PrintWriter out = res.getWriter();
        out.println(Integer.parseInt(number) + 10);
        out.close();
    }
}
