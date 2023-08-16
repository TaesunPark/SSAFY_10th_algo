package sungje.week_4.others;

import java.io.*;
import java.util.*;

public class BOJ_16395_파스칼의삼각형 {

	static int N, K, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer slicer = new StringTokenizer(br.readLine());

		N = Integer.parseInt(slicer.nextToken()) - 1;
		K = Integer.parseInt(slicer.nextToken()) - 1;
		comb(0, 0);
		System.out.println(ans);
	}

	static void comb(int start, int depth) {
		if (depth == K) {
			ans++;
			return;
		}
		if (depth == N) {
			return;
		}
		for (int i = start; i < N; i++) {
			comb(i + 1, depth + 1);
		}
	}
}
