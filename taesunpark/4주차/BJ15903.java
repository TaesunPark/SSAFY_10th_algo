import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] list = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		PriorityQueue<Long> queue = new PriorityQueue<>(N, new Comparator<Long>() {
			@Override
			public int compare(Long v1, Long v2) {
				return v1.compareTo(v2);
			}
		});
		
		for(int i = 0; i < N; i++) {
			queue.add((long) list[i]);
		}
		
		while(M-- > 0) {
			
			Long v1 = queue.poll();
			Long v2 = queue.poll();
			
			queue.add(v1 + v2);
			queue.add(v1 + v2);						
		}
				
		long sum = 0;
		
		while(!queue.isEmpty()) {
			sum += queue.poll();
		}
		
		System.out.println(sum);								
		
	}
			
}

