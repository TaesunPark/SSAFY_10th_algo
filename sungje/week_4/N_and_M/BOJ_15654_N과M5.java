package sungje.week_4.N_and_M;

import java.io.*;
import java.util.*;

public class BOJ_15654_N과M5 {
	static int N, M, numbers[], picked[];
	static BufferedWriter bw;
	static boolean[] useStates;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer slicer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(slicer.nextToken());
		M = Integer.parseInt(slicer.nextToken());
		numbers = new int[N];
		picked = new int[M];
		useStates = new boolean[N];
		
		slicer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(slicer.nextToken());
		}
		Arrays.sort(numbers);
		
		comb(0, 0);
		bw.flush();
		bw.close();
	}

	static void comb(int depth, int start) throws IOException {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				 bw.write(picked[i] + " ");
			}
			
			bw.write("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (useStates[i]) continue;
			useStates[i] = true;
			picked[depth] = numbers[i];
			comb(depth + 1, i + 1);
			useStates[i] = false;
		}
	}
}
