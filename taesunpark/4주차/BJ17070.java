import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int[] dx = { 1, 0, 1 };
	static int[] dy = { 0, 1, 1 };
	static int N;
	static int result;
	static int[][] dp;

	public static void main(String[] args) throws IOException {				

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		map = new int[N+1][N+1];
		dp = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}

		dfs(2, 1, 0);						
		
		System.out.println(result);

	}

	public static void dfs(int x, int y, int dir) {				
		
		if (x == N && y == N) {
			result++;
			return;
		}
				

		boolean check = true;
		
		for (int i = 0; i < 3; i++) {
			// i가 0이면 가로, 1이면 새로, 2이면 대각선		
			int next_x = x + dx[i];
			int next_y = y + dy[i];			
			
			// 벽에 벗어나면 넘어가기
			if(next_x < 1 || next_x > N || next_y < 1 || next_y > N) continue;
			
			if(i == 0) {
				//가로일때
				// 끝점이면 컨티뉴 하지만, 마지막 점이면 ㄱㅊ음
				if(dir == 1) continue;
				if(next_x == N && next_y != N) continue;
				if(map[next_y][next_x] == 1) {
					check = false;
					continue;
				}
			}
			
			else if(i == 1) {
				// 세로일 때
				// 끝점이면 컨티뉴 하지만, 마지막 점이면 ㄱㅊ음
				if(dir == 0) continue;
				if(next_x != N && next_y == N) continue;
				if(map[next_y][next_x] == 1) {
					check = false;
					continue;
				}
			} else {				
				// 대각선일 때
				if(check == false) {					
					continue;
				}
				if(map[next_y][next_x] == 1) continue;
				if(map[next_y-1][next_x] == 1) continue;
				if(map[next_y][next_x-1] == 1) continue;
				if(map[next_y-1][next_x-1] == 1) continue;
			}
			
			dfs(next_x, next_y, i);			
		}
								
	}

}

