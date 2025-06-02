package javaPractice;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaAnagrams {
	
	  static boolean isAnagram(String a, String b) {
		 Map <Character,Integer> mapA = new HashMap<Character,Integer>();
		 Map <Character,Integer> mapB = new HashMap<Character,Integer>();
		 Character currentChar = Character.toLowerCase(' ');
		 int currentValue= 0;
		 boolean result = true;
		 char [] firstArray = a.toCharArray();
		 char [] secondArray = b.toCharArray();		 
			 for (char c : firstArray) {
				 currentChar = Character.toLowerCase(c);
				 if(mapA.containsKey(currentChar)) {					 
					 currentValue = mapA.get(currentChar);
					 mapA.replace(currentChar, currentValue, ++currentValue);
				 } else {					 
					 mapA.put(currentChar, 1);
				 }
			}
			 for (char c : secondArray) {
				 currentChar = Character.toLowerCase(c);
				 if(mapB.containsKey(currentChar)) {					 
					 currentValue = mapB.get(currentChar);
					 mapB.replace(currentChar, currentValue, ++currentValue);
				 } else {					 
					 mapB.put(currentChar, 1);
				 }
			}
		 
			for (Map.Entry<Character, Integer> entry : mapA.entrySet()) {	
				if (mapB.containsKey(entry.getKey())){
					//key exist, then validate if count is equal
					if (mapB.get(entry.getKey()) == entry.getValue() ){
						//do nothing
					} else {
						result = false;
						break;
					}				
				} else {
					result = false;
					break;
				}
				//for each set of the map compare to the second map				
			}	 
		  return result;
	    }
	  
	 

	  public static void main(String[] args) {
	    
	        Scanner scan = new Scanner(System.in);
	        String a = "Hello";
	        String b = "hello";
	        scan.close();
	        boolean ret = isAnagram(a, b);
	        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	    }
	

}
