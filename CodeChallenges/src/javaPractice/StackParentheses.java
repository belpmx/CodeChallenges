package javaPractice;
import java.util.*;

public class StackParentheses {

	public static void main(String []argh)
	{
		Stack <Character> openChar = new Stack<Character>();
		boolean isValid = true;
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			isValid = true;
			String input=sc.next();
			openChar = new Stack<Character>();
			/* If a opening character like ( [ { appears this need to be push at the top of Stack
			 * when a closing char like ) ] } appears, then do a pop() on the stack and must be a pair
			 * continue until line is end of a mismatch occur			 *
			 * */
			for (int i =0; i< input.length(); i++) {
				if ((input.charAt(i)=='(') || (input.charAt(i)=='[')||(input.charAt(i)=='{')) {
					openChar.push(input.charAt(i));				
				}
				else{
					if (openChar.isEmpty()) {
						isValid =false;
					} else
					{
						if (input.charAt(i)==')') 
							if (!(openChar.pop() == '(')) {
								isValid =false;
							}
						
						if (input.charAt(i)==']') 
							if (!(openChar.pop() == '[')) {
								isValid =false;
							}
						
						if (input.charAt(i)=='}') 
							if (!(openChar.pop() == '{')) {
								isValid =false;
							}
					}
					
				}
				
			}
			if(!openChar.isEmpty())
				isValid =false;
			 
			if (isValid)
				System.out.println("true");
			else {
				System.out.println("false");
			}			
		}
		
	}
}
