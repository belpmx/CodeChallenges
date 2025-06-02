package problemSolving;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class ColorParser {
  String parseColor (String color){
      Map<String,String> PRESET_COLORS = new HashMap<>();
      PRESET_COLORS.put("red","#FF0000");
      PRESET_COLORS.put("green","#00FF00");
      PRESET_COLORS.put("blue","#0000FF");
      PRESET_COLORS.put("black","#000000");
      PRESET_COLORS.put("white","#FFFFFF");
      String result = "Invalid input";
    if (color.isBlank()|| color.isEmpty() || color ==null)
        return result;
    else {
        if(color.startsWith("#")){
            String hexValue =color;
            if(color.length()==4){
                 hexValue ="#"+color.charAt(1)+color.charAt(1)+color.charAt(2)+color.charAt(2)
                         +color.charAt(3)+color.charAt(3);
            }
            result = parseHex(hexValue).toString();

        }else { //is a PRESET_COLOR
            if (PRESET_COLORS.containsKey(color)){
                result = parseHex(PRESET_COLORS.get(color)).toString();
            }
        }
    }
         return result;
    }

    Map <String, Integer> parseHex(String hexValue){
        int red = Integer.parseInt(hexValue.substring(1,3),16);
        int green = Integer.parseInt(hexValue.substring(3,5),16);
        int blue = Integer.parseInt(hexValue.substring(5,7),16);
        Map <String, Integer> rgbMap = new LinkedHashMap<>();
        rgbMap.put("r",red);
        rgbMap.put("g",green);
        rgbMap.put("b",blue);
      return rgbMap;
    }
    public static void main(String[] args) {
          ColorParser parser = new ColorParser();
        System.out.println(parser.parseColor("#FF5733"));  // {red=255, green=87, blue=51}
        System.out.println(parser.parseColor("#F53"));     // {red=255, green=85, blue=51}
        System.out.println(parser.parseColor("blue"));     // {red=0, green=0, blue=255}
    }
}
