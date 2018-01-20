package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.InputStream;

public class DownloadAction extends ActionSupport {

    private InputStream asStream;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getAsStream() {
        return asStream;
    }

    public void setAsStream(InputStream asStream) {
        this.asStream = asStream;
    }

    public String down(){
        filename="dog.jpg";

        //获取在web下的图片
        //getServletContext().getResourceAsStream(相对路径)
        ServletContext servletContext = ServletActionContext.getServletContext();
        asStream = servletContext.getResourceAsStream("img/2.jpg");
        return SUCCESS;
    }
}
