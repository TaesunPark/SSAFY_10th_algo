package ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution13220 {
	static int TC;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		TC = Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			String str = br.readLine();
			if(str.length() == 1) {
				if(isNum(str.charAt(0)))System.out.println("#"+t+" "+0+"\n");
				else System.out.println("#"+t+" "+1+"\n");
				continue;
			}else {
				
				Stack<Character> stk = new Stack<>();
				for(int i=0;i<str.length();i++) {
					char now = str.charAt(i);
					if(now=='x')now ='1';
					else if(now=='X')now ='0';
					
					if(now =='(') {
						stk.push(now);
					}else if(now ==')') {
						int a = stk.pop()-'0';
						char oper = stk.pop();
						int b = stk.pop()-'0';
						stk.pop();
						int ret = oper(a,b,oper);

						stk.push((char)(ret+'0'));
					}else {
						stk.push(now);
					}
				}
				
				char sol = stk.pop();
				
				for(int i=0;i<str.length();i++) {
					char now = str.charAt(i);
					if(now=='x')now ='0';
					else if(now=='X')now ='1';
					
					if(now =='(') {
						stk.push(now);
					}else if(now ==')') {
						int a = stk.pop()-'0';
						char oper = stk.pop();
						int b = stk.pop()-'0';
						stk.pop();
						int ret = oper(a,b,oper);
						
						stk.push((char)(ret+'0'));
					}else {
						stk.push(now);
					}
					}
				
				char sol1 = stk.pop();
//				System.out.printf("#%d sol : %c sol1 : %c" , t, sol, sol1);
				if(sol != sol1) {
					System.out.println("#"+t+" "+1);
				}else System.out.println("#"+t+" "+0);
				}
				
			}	
		
	}
	private static int oper(int a, int b, char oper) {
		if(oper == '|')return a|b;
		else if(oper =='&')return a&b;
		else return a^b;
	}
	private static boolean isNum(Character peek) {
		// 
		return peek >= '0' && peek <= '9';
	}


}
