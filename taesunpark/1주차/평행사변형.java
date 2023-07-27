package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 평행사변형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int t_c = 1; t_c <= n; t_c++){
            int num = Integer.parseInt(br.readLine());
            Math.pow(n, n);
            System.out.println("#"+t_c+" "+ (int) Math.pow(num, 2));
        }

    }
}
