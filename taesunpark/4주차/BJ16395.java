import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][N+1];
		
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i = 2; i <= N; i++) {
			
			for(int j = 0; j <= i - 1; j++) {
				if(j == 0) {
					dp[i][j] = 1;
				}
				
				else if(j == i - 1) {
					dp[i][j] = 1;
				} else {
					
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];					
				}												
			}
					
		}
		
		System.out.println(dp[N][M-1]);
		
	}
}

