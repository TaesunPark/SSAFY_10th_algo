package 알고리즘_스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        if (N == 1){
            System.out.print("1");
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = Math.max(up(arr), down(arr));
        System.out.print(result);

    }

    public static int up(int[] arr){
        int left = 0;
        int right = 1;
        int result = 0;
        int sum = 1;
        int nextNum = arr[left];

        while (right < arr.length){
            if (nextNum > arr[right]){
                sum = 0;
            }
            nextNum = arr[right];
            right++;
            sum++;
            result = Math.max(sum, result);
        }

        return result;
    }

    public static int down(int[] arr){
        int left = 0;
        int right = 1;
        int result = 0;
        int sum = 1;
        int nextNum = arr[left];

        while (right < arr.length){
            if (nextNum < arr[right]){
                sum = 0;
            }
            nextNum = arr[right];
            right++;
            sum++;
            result = Math.max(sum, result);
        }

        return result;
    }

}
