package com.yy.function;




import com.yy.entity.PhoneInfo;
import com.yy.entity.Ranking;
import com.yy.entity.Weather;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class SearchDemo {
    //查询天气
    public static  void searchWeather() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要查询的城市:");
        String city = scanner.nextLine();
        URL url=new URL("http://api.k780.com/?app=weather.future&" +
                "weaid="+city+"&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        String result = getResult(inputStream);

        Map map = new HashMap();
        map.put("result",Weather.ResultBean.class);
        JSONObject object=JSONObject.fromObject(result);
        Weather weather =(Weather) JSONObject.toBean(object, Weather.class, map);
        List<Weather.ResultBean> resultBeans=weather.getResult();
        for (Weather.ResultBean resultBean : resultBeans) {
            System.out.println("日期:" + resultBean.getDays() + "\n星期:" + resultBean.getWeek() +
                    "\n温度:"+resultBean.getTemperature()+"\n天气:"+resultBean.getWeather());
        }
    }

    private static String getResult(InputStream inputStream) throws IOException {
        byte buf[]= new byte[1024];
        int len = 0;
        StringBuffer sb=new StringBuffer();
        while ((len = inputStream.read(buf))!=-1) {

            sb.append(new String(buf, 0, len));
        }
        return new String(sb);
    }


    //查询电话号码
    public static void searchPhone() throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入手机号码:");
        String phone=scanner.nextLine();
        URL url=new URL("http://api.k780.com/?app=phone.get&phone="+phone +
                "&appkey=29836&sign=4fe58a60443a900a251f8b05763d4622&format=json");
        URLConnection urlConnection=url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        String result = getResult(inputStream);

        JSONObject object=JSONObject.fromObject(result);
        PhoneInfo phoneInfo=(PhoneInfo)JSONObject.toBean(object,PhoneInfo.class);
        PhoneInfo.ResultBean result1 = phoneInfo.getResult();
        System.out.println("号码:"+result1.getPhone()+"\n卡号信息:"+result1.getCtype());
    }
    public static void searchTen() throws IOException {
        URL url=new URL("http://192.168.20.194:8080/day16/ten");
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        String result = getResult(inputStream);
        JSONArray jsonArray=JSONArray.fromObject(result);
        for (int i = 0; i <jsonArray.size() ; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            Ranking ranking = (Ranking) JSONObject.toBean(jsonObject, Ranking.class);
            System.out.println("第"+(i+1)+"名,昵称为:"+ranking.getNickname()+"\t成绩为:"+ranking.getScore());
        }
    }
}
