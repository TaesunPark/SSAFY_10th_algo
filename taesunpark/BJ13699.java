import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] t = new long[n + 1];
        if (n == 0){
            System.out.println("1");
            return;
        }
        if (n == 1){
            System.out.println("1");
            return;
        }
        t[0] = 1;

        // t[n] = t[0] * t[n-1] + t[1] * t[n-2] + t[n-1] * t[0]
        t[1] = t[0] * t[0];
        t[2] = t[0] * t[1] + t[1] * t[0];

        for(int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 0; j < i; j++) {
                sum += t[i - j - 1] * t[j];
            }

            t[i] = sum;
        }

        System.out.println(t[n]);
    }


}

