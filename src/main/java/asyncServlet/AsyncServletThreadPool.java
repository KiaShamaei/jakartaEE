package asyncServlet;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@WebServlet(urlPatterns = "/async-pool" , asyncSupported = true)
public class AsyncServletThreadPool extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<p>this is writer from set query String : " + Thread.currentThread().getName() + "</p>");
        out.println("<progress id='progress' max=100 ></progress>");
        AsyncContext context = request.startAsync();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(()->{
                    int i = 0 ;
                    while(i <= 100){
                        try {

                            out.println("<p>the thread start : " + Thread.currentThread().getName() + "</p>");
                            i=i+10 ;
                            out.println("<script>document.getElementById('progress').value= \'"+ i + "\'</script>");
                            out.flush();
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                    out.println("<p>this is the last record : " + Thread.currentThread().getName() + "</p>");
                    out.println("</body></html>");
                    out.close();
                });
    }
}
