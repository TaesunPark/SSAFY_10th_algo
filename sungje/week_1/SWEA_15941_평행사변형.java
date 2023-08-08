package sungje.week_1;

import java.io.*;

public class SWEA_15941_평행사변형 {
	public static void main(String[] args) throws IOException {
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bfReader.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(bfReader.readLine());
			System.out.printf("#%d %d\n", testCase, N * N);
		}
	}
}
