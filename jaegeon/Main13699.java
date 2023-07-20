package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main13699 {
	static long[] dp = new long[36];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());	
		
		
		System.out.println(dfs(n));

	}

	private static long dfs(int n) {
		if(dp[n]>0)return dp[n];
		if(n == 0) {
			dp[n] = 1;
			return dp[n];
		}
		
		long sum = 0;
		for(int i=1;i<=n;i++) {
			sum += dfs(i-1)*dfs(n-i);
		}
		dp[n] = sum;
		return  dp[n];
	}

}