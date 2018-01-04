package util;

public class ELUtil {

    /**
     * 1、必须是静态方法
     * 2、方法必须有返回值
     *
     * @param input
     * @return
     */

    public static String reverse(String input){

        return "哈哈哈哈嗝";
    }
    public static String reverseString(String str,int start,int node){
        char[] chars = str.toCharArray();
        if (start<node){
            char temp=chars[start];
            chars[start]=chars[node];
            chars[node]=temp;
            start++;
            node--;
            str =reverseString(String.valueOf(chars),start,node);
        }
        return str;
    }
}
