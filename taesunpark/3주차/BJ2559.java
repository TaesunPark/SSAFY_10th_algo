import java.util.*;
import java.io.*;


public class Main {

	
	public static void main(String[] args) throws IOException{
		int N, M;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int max = Integer.MIN_VALUE;
		int sum = 0;
		
		for(int i = 0; i < M; i++) {
			sum += arr[i]; 
		}
		
		max = Math.max(max, sum); 
		
		for(int i = 0; ; i++) {
			if(i + M == N) break;								
			sum += arr[i + M];
			sum -= arr[i];								
			max = Math.max(max, sum); 			
		}
		
		System.out.print(max);
		
		
		
	}
}

