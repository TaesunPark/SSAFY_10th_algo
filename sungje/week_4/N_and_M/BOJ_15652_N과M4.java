package sungje.week_4.N_and_M;

import java.io.*;
import java.util.*;

public class BOJ_15652_N과M4 {
    
	static int N, M, numbers[], picked[];
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer slicer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(slicer.nextToken());
		M = Integer.parseInt(slicer.nextToken());
		numbers = new int[N];
		for (int i = 1; i < N + 1; i++) numbers[i - 1] = i;
		
		picked = new int[M];

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

		for (int i = start; i < N; i++) {
			picked[depth] = numbers[i];
			comb(depth + 1, i);
		}
	}

}
