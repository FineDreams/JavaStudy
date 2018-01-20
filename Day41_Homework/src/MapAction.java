import com.opensymphony.xwork2.ActionSupport;
import domain.User;

import java.util.HashMap;
import java.util.Map;

public class MapAction extends ActionSupport{
    public Map<Integer, User> getMap() {
        return map;
    }

    public void setMap(Map<Integer, User> map) {
        this.map = map;
    }

    private   Map<Integer, User> map=new HashMap<>();

    public String map(){
            for (Integer key : map.keySet()) {
                System.out.println(key + "----" + map.get(key));
            }
        return "map";
    }
}
