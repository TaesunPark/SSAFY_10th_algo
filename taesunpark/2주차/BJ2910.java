package 알고리즘_스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2910 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        HashMap<Integer, Node> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            int key = Integer.parseInt(st.nextToken());
            if (map.containsKey(key)){
                Node node = map.get(key);
                node.cnt += 1;
            } else{
                map.put(key, new Node(1,i, key));
            }
        }

        for (Node node : map.values()){
            queue.add(node);
        }
        int size = queue.size();
        for (int i = 0; i < size; i++){
            Node node = queue.poll();
            for (int j = 0; j < node.cnt; j++){
                System.out.print(node.value + " ");
            }
        }

    }

    public static class Node implements Comparable<Node>{
        int cnt;
        int idx;
        int value;
        public Node(int cnt, int idx, int value){
            this.idx = idx;
            this.cnt = cnt;
            this.value = value;
        }
        public int compareTo(Node node){
            if (this.cnt == node.cnt) return this.idx - node.idx;
            return node.cnt - this.cnt;
        }
    }
}
