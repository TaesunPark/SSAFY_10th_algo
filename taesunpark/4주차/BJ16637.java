import java.util.*;
import java.io.*;

public class Main {
	
	static char[] list; // 입력 리스트
	static int[] numbers; // 연산해야 하는 숫자들
	static char[] op; // 연산자 담기
	static int N;
	static int M;
	static long max;
	
	public static void main(String[] args) throws IOException{						
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		N = Integer.parseInt(br.readLine());
		
		if(N == 1) {
			System.out.print(br.readLine());
			return;
		}
		
		list = br.readLine().toCharArray();
		
		numbers = new int[N/2 + 1];
		op = new char[N/2];
		int idx = 0;
		int idx1 = 0;
		M = N / 2;
		
		for(int i = 0; i < N; i++) {
			if(i % 2 == 0) {
				numbers[idx++] = list[i] - '0';
			}else {
				op[idx1++] = list[i];
			}
		}
		
		max = Long.MIN_VALUE;		
		if(N == 1) {
			System.out.println(numbers[0]);
			return;
		}
		dfs(1, numbers[0]);
		System.out.println(max);
	}
	
	public static void dfs(int idx, long result) {
		
		if(idx > M) {
			max = Math.max(result, max);
			return;
		}
							
		dfs(idx+1, cal(result, op[idx-1], numbers[idx]));
		
		if(idx < M) {						
			dfs(idx+2, cal(result, op[idx - 1], cal(numbers[idx], op[idx], numbers[idx+1])));
		}
		
	}
	
	public static long cal(long value, char ch, long value2) {
		
		switch(ch) {
			case '*':
				return value * value2;
			case '/':
				return value / value2;
			case '-':
				return value - value2;
			case '+':
				return value + value2;
		}
		
		return 0;
	}

}

