package sungje.week_4.others;

import java.io.*;
import java.util.*;

public class BOJ_15903_카드합체놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer slicer = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(slicer.nextToken());
		int M = Integer.parseInt(slicer.nextToken());
		long result = 0;
		long[] cards = new long[N];

		slicer = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cards[i] = Long.parseLong(slicer.nextToken());
		}

		while (M > 0) {
			Arrays.sort(cards);
			long calced = cards[0] + cards[1];
			cards[0] = calced;
			cards[1] = calced;
			M--;
		}
		for (int i = 0; i < N; i++) {
			result += cards[i];
		}
		
		System.out.println(result);
	}
}
