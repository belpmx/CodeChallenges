package javaPractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor {
public static void main(String[] args){
	/*
	 * () inside parenthesis is a group, it can be called by order
	 * .+ dot is any character plus is at least 1 time
	 * [^<]exclude the open tag expression
	 * \\1 this means to call group 1 and use it = (.+), this will be ensuring to use as it was on opening tag
	 * */
		String tapPattern = "<(.+)>([^<]+)</\\1>";
		Pattern ptrn = Pattern.compile(tapPattern);
		Matcher match = null;		
		boolean isFound = false;		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		while(testCases>0){
			String line = in.nextLine();
			isFound = false;
			match = ptrn.matcher(line);
			while(match.find()) {
				System.out.println(match.group(2));
				isFound = true;
			}
			if (!isFound) {
				System.out.println("None");
			}          
			testCases--;
		}
	}

}
