import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    static boolean[][] check;
    static int w, h;
    static int[] dx = {-1,0,1,0, 1, -1, 1, -1};
    static int[] dy = {0,1,0,-1, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0){
                break;
            }

            map = new int[h][w];
            check = new boolean[h][w];

            for (int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                    if (check[i][j] == true) continue;
                    if (map[i][j] == 0) continue;
                    check[i][j] = true;
                    dfs(j, i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y){

        for (int i = 0; i < 8; i++){
            int next_x = dx[i] + x;
            int next_y = dy[i] + y;

            if (next_x < 0 || next_x >= w || next_y >= h || next_y < 0) continue;
            if (check[next_y][next_x] == true) continue;
            if (map[next_y][next_x] == 0) continue;
            check[next_y][next_x] = true;
            dfs(next_x, next_y);
        }

    }
}

