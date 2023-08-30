import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] list;
    static ArrayList<Integer>[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int len = (int) Math.pow(2, N) - 1;
        list = new int[len];
        trees = new ArrayList[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < len; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
            trees[i] = new ArrayList<>();
        }

        dfs(0, len, 0);

        for (int i = 0; i < N; i++){
            for (int j = 0; j < trees[i].size(); j++){
                System.out.print(trees[i].get(j) + " ");
            }
            System.out.println("");
        }
    }

    public static void dfs(int st, int en, int depth){
        int mid = (st + en) / 2;
        trees[depth].add(list[mid]);
        if (mid <= st) return;
        if (mid >= en) return;
        dfs(st, mid - 1, depth + 1);
        dfs(mid + 1, en, depth + 1);
    }


}

