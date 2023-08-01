import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReBJ11055 {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;

        for (int i = 1; i <= N; i++){
            for (int j = i - 1; j >= 0; j--){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                    max = Math.max(dp[i], max);
                }
            }
        }

        System.out.print(max);

    }
}
