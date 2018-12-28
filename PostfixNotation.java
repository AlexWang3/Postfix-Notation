package PostfixNotation;
import java.util.*;

public class PostfixNotation {
	static String input;
	static Stack<Float> numbers=new Stack();
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		input=in.nextLine();
		String nums="";
		float num;
		boolean operation=false;
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i)=='*') {
				multiplication();
				operation=true;
			}
			else if(input.charAt(i)=='/') {
				division();
				operation=true;
			}
			else if(input.charAt(i)=='+') {
				addition();
				operation=true;
			}
			else if(input.charAt(i)=='-') {
				subtraction();
				operation=true;
			}
			else if(input.charAt(i)=='^') {
				exponentiation();
				operation=true;
			}
			else if(input.charAt(i)==' '&&!operation) {
				num=Float.parseFloat(nums);
				numbers.push(num);
				nums="";
			}
			else if(input.charAt(i)==' '&&operation) {
				operation=false;
			}	
			else {
				nums=nums+input.charAt(i);
			}
		}
		System.out.printf("%.1f", numbers.pop());
	}
	private static void exponentiation() {
		float a=numbers.pop();
		float b=numbers.pop();
		numbers.push((float)Math.pow(b, a));
		
	}
	private static void subtraction() {
		float a=numbers.pop();
		float b=numbers.pop();
		numbers.push(b-a);
	}
	private static void addition() {
		float a=numbers.pop();
		float b=numbers.pop();
		numbers.push(a+b);		
	}
	private static void division() {
		float a=numbers.pop();
		float b=numbers.pop();
		numbers.push(b/a);
		
	}
	private static void multiplication() {
		float a=numbers.pop();
		float b=numbers.pop();
		numbers.push(a*b);
		
	}
}
