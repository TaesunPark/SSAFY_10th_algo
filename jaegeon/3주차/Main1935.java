package user;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main1935 {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		char tmp[] = br.readLine().toCharArray();
		int arr[] = new int[tmp.length];
		
		for(int i=0;i<tmp.length;i++) {
			if(tmp[i]=='+') {
				arr[i] = 101;
			}else if(tmp[i] =='-') {
				arr[i] = 102;
			}else if(tmp[i] =='*') {
				arr[i] = 103;
			}else if(tmp[i] =='/') {
				arr[i] = 104;
			}else arr[i] = tmp[i];
		}
		
		int num[] = new int[n];
		for(int i=0;i<n;i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i] >= 'A' && arr[i] <= 'Z') {
				arr[i] = (num[arr[i]-'A']);
			}
		}
		
		
		Stack<Double> stk = new Stack<>();
		for(int x : arr) {
			if(x <= 100) {
				stk.push((double)(x));
			}else {
				double back = stk.pop();
				double front = stk.pop();
				
				double res = oper(front, back, x);
				stk.push(res);
			}
		}
		bw.write(String.format("%.2f", stk.pop()));
		bw.flush();
		bw.close();
		br.close();
	}
	private static double oper(double front, double back, int x) {
		if(x==101)return front + back;
		else if(x==102)return front - back;
		else if(x==103)return front * back;
		else return front / back;
	}

}