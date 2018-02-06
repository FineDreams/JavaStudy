import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "UpFileServlet",urlPatterns = "/up")
public class UpFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String upFile(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {

        String savePath = request.getServletContext().getRealPath("/files");

        File file=new File(savePath);

        if (!file.isDirectory()||!file.exists()){
            file.mkdir();
        }
        DiskFileItemFactory factory=new DiskFileItemFactory();

        ServletFileUpload fileUpload = new ServletFileUpload(factory);

        fileUpload.setHeaderEncoding("UTF-8");

//        form表单允许的最大上传文件大小
        fileUpload.setSizeMax(1024*1024*10);
        fileUpload.setFileSizeMax(1024*1024);

//        判断文件是否是从form表单中提交过来的
        if (!ServletFileUpload.isMultipartContent(request)){
            return "f:index.jsp";
        }

        List<FileItem> fileItems = fileUpload.parseRequest(request);

        for (FileItem fileItem : fileItems) {
            if (!fileItem.isFormField()){
                continue;
            }
            String name = fileItem.getName();
            if (name==null||name.equals("")){
                continue;
            }
            String fileName = name.substring(name.lastIndexOf("\\") + 1);

            InputStream is = fileItem.getInputStream();

            FileOutputStream fos = new FileOutputStream(savePath+"\\"+fileName);

            byte[] buff= new byte[1024 * 1024 * 1024];

            int len=0;

            while ((len=is.read(buff))>0){
                fos.write(buff);
            }
            is.close();
            fos.close();
            file.delete();
        }
        return "f:index.jsp";
    }
}
