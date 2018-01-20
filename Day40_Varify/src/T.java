import com.zhuang.util.VerifyCode;
import org.junit.Test;

import java.util.UUID;

public class T {

    @Test

    public void t(){
        String string = UUID.randomUUID().toString();
        String output = VerifyCode.getInstance().output("C:\\Users\\lanou3g\\Desktop\\验证码/"+string+".jpg");
        System.out.println(output);
    }

}
