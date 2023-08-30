import java.util.Scanner;

public class Main {

    static int N, M;
    static int result;
    static Node[] list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        list = new Node[N];
        result = 0;

        for (int i = 0; i < N; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            Node node = new Node(v1, v2);
            list[i] = node;
        }
        boolean[] visited = new boolean[N];
        dfs(0, visited, 0, 0);
        System.out.print(result);
    }

    static void dfs(int day, boolean[] visited, int value, int st){

        if (day <= M){
            result = Math.max(result, value);
        }else{
            return;
        }

        for (int i = st; i < N; i++){
            if (visited[i] == true) continue;
            visited[i] = true;
            dfs(list[i].remainTime + day, visited, list[i].page + value, i);
            visited[i] = false;
        }
    }

    static class Node{
        int remainTime;
        int page;
        public Node(int remainTime, int page){
            this.remainTime = remainTime;
            this.page = page;
        }
    }
}

