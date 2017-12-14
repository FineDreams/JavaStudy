package com.yy.workTest1;




import net.sf.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearchDemo {
    public static  void searchWeather() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的城市:");
        String city = scanner.nextLine();
        URL url=new URL("http://api.k780.com/?app=weather.today&" +
                "weaid="+city+"&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json");
        InputStream in=url.openStream();
        ByteArrayOutputStream out= new ByteArrayOutputStream();
        readIO(in, out);
        byte b[]=out.toByteArray( );
        String result = new String(b, "utf-8");
        Map map = new HashMap();
        map.put("result",Weather.ResultBean.class);
        JSONObject object=JSONObject.fromObject(result);
        Weather weather =(Weather) JSONObject.toBean(object, Weather.ResultBean.class, map);
        List<Weather.ResultBean> resultBeans=weather.getResult();
        for (Weather.ResultBean resultBean : resultBeans) {
            System.out.println("日期:" + resultBean.getDays() + "\n星期:" + resultBean.getWeek() +
                    "\n温度:"+resultBean.getTemperature()+"\n天气:"+resultBean.getWeather());
        }
    }

    private static void readIO(InputStream in, ByteArrayOutputStream out) throws IOException {
        try {
            byte buf[]= new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static void searchPhone() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入手机号码:");
        String phone=scanner.nextLine();
        URL url=new URL("http://api.k780.com/?app=phone.get&phone="+phone +
                "&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json");
        InputStream is=url.openStream();
        ByteArrayOutputStream out= new ByteArrayOutputStream();
        readIO(is, out);
        byte b[]=out.toByteArray( );
        String result = new String(b, "utf-8");

        JSONObject object=JSONObject.fromObject(result);
        PhoneInfo phoneInfo=(PhoneInfo)JSONObject.toBean(object,PhoneInfo.class);
        PhoneInfo.ResultBean result1 = phoneInfo.getResult();
        System.out.println("号码:"+result1.getPhone()+"\n卡号信息:"+result1.getCtype());
    }
}
