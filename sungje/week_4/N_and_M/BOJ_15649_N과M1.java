package sungje.week_4.N_and_M;

import java.io.*;
import java.util.*;

public class BOJ_15649_N과M1 {
    static int N, M, numbers[], picked[];
	static boolean[] useStates;

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
		useStates = new boolean[N];

		perm(0);
	}

	static void perm(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(picked[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (useStates[i]) continue;
			
			useStates[i] = true;
			picked[depth] = numbers[i];
			perm(depth + 1);
			useStates[i] = false;
		}
	}
}
