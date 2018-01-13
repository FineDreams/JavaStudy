import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {

    private List<Book> books;

    @Override
    public void init() throws ServletException {
        books = new ArrayList<>();
        for (int i = 0; i < 201; i++) {
            Book book=new Book("白眉大侠"+i,"吴承恩",i+"","武侠小说");
            books.add(book);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得前端给我的页码参数
        //pc=pageCode

        PageBean pageBean=new PageBean();
        String pc = request.getParameter("pc");
        int begin=(Integer.parseInt(pc)-1)*pageBean.getPageSize();
        int end=Integer.parseInt(pc)*pageBean.getPageSize();
        List<Book> bookList = this.books.subList(begin, end);


        pageBean.setBooks(bookList);
        //setTotalData数据条数是从数据库通过select count(*) from table;查出来的
        pageBean.setTotalData(201);
        pageBean.setPageCode(Integer.parseInt(pc));


        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
