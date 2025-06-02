package javaPractice;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class IpRegex {
	
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
	

	static class MyRegex {
		//1 digit from 0-9 
		// digit from 10 -99 				\\d{1,2}
		
		//3 digit from 0  + 00-99
		//3 digit from 1  + 00-99 			(0|1)\\d{2}
		
		//3 digit from 2 + 0-4 + 0-9		2[0,4]\\d
		//3 digit from 25 + 0-5
		String baseIpNumber = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";		
	    public String pattern = baseIpNumber+"\\."+baseIpNumber+"\\."+baseIpNumber+"\\."+baseIpNumber;
	}

}
