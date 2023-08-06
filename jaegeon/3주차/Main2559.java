package user;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2559 {
	static int n, k, arr[], psum[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		psum = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int sum = 0;
		for(int i=0;i<k;i++) {
			sum += arr[i];
		}
		int ret = sum;
		for (int i = k; i < n; i++) {
			sum -= arr[i-k];
			sum += arr[i]; 
			
			ret = Math.max(ret, sum);
			
		}
		bw.write(String.valueOf(ret));
		bw.flush();
		bw.close();
	}

}