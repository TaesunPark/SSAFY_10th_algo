package sungje.week_4.N_and_M;

import java.io.*;
import java.util.*;

public class BOJ_15650_N과M2 {
    static int N, M, numbers[], picked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer slicer = new StringTokenizer(br.readLine());
		N = Integer.parseInt(slicer.nextToken());
		M = Integer.parseInt(slicer.nextToken());
		numbers = new int[N];
		for (int i = 1; i < N + 1; i++) {
			numbers[i - 1] = i;
		}
		picked = new int[M];

		comb(0, 0);
	}

	static void comb(int depth, int start) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(picked[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			
			picked[depth] = numbers[i];
			comb(depth + 1, i + 1);
		}
	}
}
