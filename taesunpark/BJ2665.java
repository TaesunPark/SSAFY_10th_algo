import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[][] map;
    private static int min;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int n;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        min = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++){
            String str = br.readLine();
            Arrays.fill(dp[i], Integer.MAX_VALUE);

            for (int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        // x, y,
        bfs();
        System.out.print(min);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0, 0));
        dp[0][0] = 1;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == n - 1){
                min = Math.min(node.cnt, min);
            }
            for (int i = 0; i < 4; i++){
                int n_x = node.x + dx[i];
                int n_y = node.y + dy[i];
                if (n_x < 0 || n_x >= n || n_y < 0 || n_y >= n) continue;

                if (visited[n_y][n_x] == true){
                    if (map[n_y][n_x] == 0){
                        if (dp[n_y][n_x] <= node.cnt + 1) continue;
                        dp[n_y][n_x] = node.cnt + 1;
                        queue.add(new Node(n_x, n_y, node.cnt + 1));
                    }else{
                        if (dp[n_y][n_x] <= node.cnt) continue;
                        dp[n_y][n_x] = node.cnt;
                        queue.add(new Node(n_x, n_y, node.cnt));
                    }
                } else{
                    visited[n_y][n_x] = true;
                    if (map[n_y][n_x] == 0) {
                        queue.add(new Node(n_x, n_y, node.cnt + 1));
                    }else{
                        queue.add(new Node(n_x, n_y, node.cnt));
                    }
                }



            }
        }
    }

    public static class Node{
        int x;
        int y;
        int cnt;
        public Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


}

