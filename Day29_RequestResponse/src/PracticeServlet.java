import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PracticeServlet",urlPatterns = "/practice")
public class PracticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object count = getServletContext().getAttribute("count");
        if (count==null){
            getServletContext().setAttribute("count",1);
            System.out.println("这是第1次访问");
        }else {
            Integer i=(Integer) count;
            i++;
            System.out.println("这是第"+i+"次访问");
            getServletContext().setAttribute("count",i);
        }
    }
}
