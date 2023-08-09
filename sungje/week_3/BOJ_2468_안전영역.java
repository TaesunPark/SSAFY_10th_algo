package sungje.week_3;

import java.io.*;
import java.util.*;

public class BOJ_2468_안전영역 {
	static int N, curCnt, maxCnt, DIRCOL[] = { 0, 1, 0, -1 }, DIRROW[] = { 1, 0, -1, 0 };
	static int[][] map, subMap;
	static Queue<Integer[]> Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer slicer;

		maxCnt = 1;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		subMap = new int[N][N];
		Q = new ArrayDeque<Integer[]>();
		

		for (int i = 0; i < N; i++) {
			slicer = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(slicer.nextToken());
			}
		}

		for (int surfaceHeight = 1; surfaceHeight < 100; surfaceHeight++) {
			curCnt = 0;
			for (int i = 0; i < N; i++) {
				subMap[i] = Arrays.copyOf(map[i], N);
			}
			for (int col = 0; col < N; col++) {
				for (int row = 0; row < N; row++) {
					if (surfaceHeight < subMap[col][row]) {
						Integer[] colRow = new Integer[] { col, row };
						Q.offer(colRow);
						subMap[col][row] = 0;
						checkSafetyArea(colRow, surfaceHeight);
						curCnt += 1;
					}
				}
			}
			maxCnt = Math.max(maxCnt, curCnt);
		}
		System.out.println(maxCnt);

	}

	static void checkSafetyArea(Integer[] colRow, int height) {
		while (Q.size() > 0) {
			Integer[] cr = Q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int dCol = cr[0] + DIRCOL[dir];
				int dRow = cr[1] + DIRROW[dir];
				if (0 <= dCol && dCol < N && 0 <= dRow && dRow < N && subMap[dCol][dRow] > height) {
					subMap[dCol][dRow] = 0;
					Q.offer(new Integer[] { dCol, dRow });
				}
			}
		}
	}
}
