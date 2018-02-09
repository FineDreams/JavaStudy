import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Date;

public class TimeTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        Date date=new Date();
        try {
            pageContext.getOut().print("进入jsp页面的时间:"+date);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }
}
