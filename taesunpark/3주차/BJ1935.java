import java.util.*;
import java.io.*;


public class Main {

	
	public static void main(String[] args) throws IOException{
		int N;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
				
		Stack<Double> stack = new Stack<>();
		double[] arr = new double[27];
		
		// ABC*+DE/-
		//
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = 0; i < str.length(); i++) {			
			char ch = str.charAt(i);
			double v1;
			double v2;
			switch(ch) {
				case '/':
					v1 = stack.pop();
					v2 = stack.pop();					
					stack.add(v2 / v1);
					break;
				case '*':
					v1 = stack.pop();
					v2 = stack.pop();					
					stack.add(v2 * v1);
					break;
				case '+':
					v1 = stack.pop();
					v2 = stack.pop();					
					stack.add(v2 + v1);
					break;
				case '-':
					v1 = stack.pop();
					v2 = stack.pop();
					stack.add(v2 - v1);
					break;
				default:					
					stack.add(arr[str.charAt(i) - 'A']);
					break;
			}								
		}
		
		System.out.printf("%.2f",stack.pop());
		
	}
}

