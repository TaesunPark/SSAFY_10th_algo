import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            list.add(str);
        }

        Collections.sort(list, (o1, o2)->{
            return o1.length() - o2.length();
        });
        int cnt = 0;

        for (int i = 0; i < list.size() - 1; i++){
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(j).substring(0, list.get(i).length()).equals(list.get(i))){
                    cnt++;
                    break;
                }
            }
        }

        System.out.print(N-cnt);

    }
}

