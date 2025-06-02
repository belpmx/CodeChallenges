package problemSolving;

import java.util.HashMap;
import java.util.Map;

public class GetParamsUrl {
    public static Map<String, String> getParameters(String url){
        int size = url.length();
        int index = url.indexOf("?");
        Map <String, String> myHashMap = new HashMap<>();
        String [] parameters = url.substring(index+1,size).split("&");
        for(String duo:parameters){
            String [] pair = duo.split("=");
            myHashMap.put(pair[0],pair[1]);
        }
       // System.out.println("index of ? "+ index);
        return myHashMap;
    }

    public static void main(String[] args) {
        String myUrl = "www.acme.com?id=123&age=99";
        System.out.println(getParameters(myUrl));

    }
}
