package user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2491 {
	static int n, arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> bigQ = new Stack<>();
		Stack<Integer> smallQ = new Stack<>();
		
		
		int ret = 0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		bigQ.push(arr[0]);
		smallQ.push(arr[0]);
		
		for(int i=1;i<n;i++) {
			
			if(!bigQ.isEmpty() && arr[i] > bigQ.peek()) {
				bigQ.push(arr[i]);
				ret = Math.max(ret, smallQ.size());
				smallQ.clear();
				smallQ.push(arr[i]);
				
				continue;
			}else if(!smallQ.isEmpty() && arr[i] < smallQ.peek()) {
				smallQ.push(arr[i]);
				ret = Math.max(ret, bigQ.size());
				bigQ.clear();
				bigQ.push(arr[i]);
				
				continue;
			}
			
			if(smallQ.isEmpty() || arr[i] == smallQ.peek()) {
				smallQ.push(arr[i]);
			}
			if(bigQ.isEmpty() || arr[i] == bigQ.peek()) {
				bigQ.push(arr[i]);
			}
			
		}
		ret = Math.max(ret, bigQ.size());
		ret = Math.max(ret, smallQ.size());
		
		bw.write(String.valueOf(ret));
		bw.flush();
		
	}

}
