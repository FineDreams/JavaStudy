import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AjaxServlet",urlPatterns = "/show")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] arr={
                "a"
                ,"as"
                ,"asf"
                ,"asfg"
                ,"asfgh"
                ,"asfghj"
        };

        String input = request.getParameter("input");

        List<String> list=new ArrayList<>();

        if (input==null){
            return;
        }
        for (String s : arr) {
            if (s.startsWith(input)){
                list.add(s);
            }
        }

        JSONArray jsonArray=JSONArray.fromObject(list);
        response.getWriter().write(jsonArray.toString());

    }
}
