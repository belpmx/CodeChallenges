package javaPractice;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HashsetPairs {
	
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int t = s.nextInt();
	        String [] pair_left = new String[t];
	        String [] pair_right = new String[t];
	        
	        for (int i = 0; i < t; i++) {
	            pair_left[i] = s.next();
	            pair_right[i] = s.next();
	        }
	        HashSet<String> pairs = new HashSet<String>();
	        String concat = "";
	        for(int i = 0; i < pair_left.length; i++) {
	        	concat = "";
	        	concat = pair_left[i] +" "+  pair_right[i];
	        	if (!pairs.contains(concat))
	        		pairs.add(concat);
	        	System.out.println(pairs.size());
	        	concat = null;// to do not store in java heap and  garbage collector might be called
	        } 
	   }

}
