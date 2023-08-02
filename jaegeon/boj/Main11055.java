package user;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main11055 {
	static int n, arr[], dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		for(int i=1;i<n;i++) {
			dp[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[i] >arr[j])dp[i] = Math.max(dp[j]+arr[i], dp[i]);
				
			}
		}
		
		int ret = 0;
		for(int i=0;i<dp.length;i++) {
			ret = Math.max(ret, dp[i]);
		}
		System.out.println(ret);
	}

}