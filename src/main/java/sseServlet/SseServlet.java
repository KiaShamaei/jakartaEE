package sseServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/HelloServlet")
public class SseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("request is recive  ");
        res.setContentType("text/event-stream");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.write("data: " + System.currentTimeMillis() + "\n\n");
        out.flush();
        System.out.println("call ...");

        try {
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();

    }
}
