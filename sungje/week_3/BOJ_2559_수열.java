package sungje.week_3;

import java.io.*;
import java.util.*;

public class BOJ_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer slicer = new StringTokenizer(br.readLine());

		int LEN = Integer.parseInt(slicer.nextToken());
		int RANGE = Integer.parseInt(slicer.nextToken());
		int[] nums = new int[LEN];

		slicer = new StringTokenizer(br.readLine());
		for (int i = 0; i < LEN; i++) {
			nums[i] = Integer.parseInt(slicer.nextToken());
		}
		
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < LEN; i++) {
			if (i + RANGE > LEN) break;
			
			int calced = 0;
			for (int j = i; j < i + RANGE; j++) {
				calced += nums[j];
			}
			maxValue = Math.max(maxValue, calced);
		}
		
		System.out.println(maxValue);
	}
}
