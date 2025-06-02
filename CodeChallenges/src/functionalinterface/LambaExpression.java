package functionalinterface;
import java.io.*;
import java.util.*;

interface PerformOperation {
 boolean check(int a);
}

class MyMath {
	 public static boolean checker(PerformOperation p, int num) {
	  return p.check(num); 
	  }
	 /*
	  * Lambda structure
	  * return (arguments to be sent to inner lambda functionality)
	  * interface PerformOperation has check(int a), then the argument is a int
	  * return must be as the expected by the interface in this case boolean
	  * -> starts the functionality of lambda
	  * {//code goes here}; body of the lambda
	  * code must return the expected type specified on the interface
	  */
	 public static PerformOperation isOdd() {
		 return (int num)->{
			 //a= 1, 1 % 2 = 0, is this equal to 1 ? then return false
			 return (num%2 ==1);				 
		 };
	 }
	 public static PerformOperation isPrime() {
		 return (int num)->{
			 return java.math.BigInteger.valueOf(num).isProbablePrime(1);			 			 
		 };		 
	 }
	 public static PerformOperation isPalindrome() {
		 return (int num)->{
			 String original = String.valueOf(num);
			 String reverse = new StringBuilder(Integer.toString(num)).reverse().toString();
			 return original.equals(reverse);
		 };
	 }
	 
}

public class LambaExpression {
	public static void main(String[] args) throws IOException {
		  MyMath ob = new MyMath();
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int T = Integer.parseInt(br.readLine());
		  PerformOperation op;
		  boolean ret = false;
		  String ans = null;
		  while (T--> 0) {
		   String s = br.readLine().trim();
		   StringTokenizer st = new StringTokenizer(s);
		   int ch = Integer.parseInt(st.nextToken());
		   int num = Integer.parseInt(st.nextToken());
		   if (ch == 1) {
		    op = ob.isOdd();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "ODD" : "EVEN";
		   } else if (ch == 2) {
		    op = ob.isPrime();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PRIME" : "COMPOSITE";
		   } else if (ch == 3) {
		    op = ob.isPalindrome();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

		   }
		   System.out.println(ans);
		  }
		 }


}
