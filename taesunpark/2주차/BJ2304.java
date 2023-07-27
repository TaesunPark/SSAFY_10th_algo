import java.util.*;
import java.io.*;

public class BJ2304 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        int[] list2 = new int[1001];
        StringTokenizer st;
        int max = 0;
        int idx = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list2[v1] = v2;
            max = Math.max(v2, max);
            list.add(new Node(v1, v2));
        }

        list.sort((o1,o2)->{
            return o1.x - o2.x;
        });

        for (int i = 0; i <= list.get(list.size()-1).x; i++){
            if (max == list2[i]){
                idx = i;
            }
        }

        int sum = 0;
        int h = list.get(0).y;

        // 왼쪽부터 ->
        for(int i = list.get(0).x; i <= idx; i++) {
            if (h < list2[i]){
                h = list2[i];
            }
            sum += h;
        }

        h = list.get(list.size()-1).y;

        for(int i = list.get(list.size()-1).x; i > idx; i--) {
            if (h < list2[i]){
                h = list2[i];
            }
            sum += h;
        }

        System.out.println(sum);
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
