import java.util.Scanner;
import java.util.Stack;

public class BJ25497 {

    static int rSize;
    static int kSize;
    static int result;
    public static void main(String[] args) {
        rSize = 0;
        kSize = 0;
        result = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String str = sc.next();

        for (int i = 0; i < n; i++){
            if (str.charAt(i) == 'S'){
                kSize++;
            }
            else if (str.charAt(i) == 'L'){
                rSize++;
            }
            else if (str.charAt(i) == 'R'){
                if (rSize > 0){
                    rSize--;
                    result++;
                } else{
                    break;
                }
            }
            else if (str.charAt(i) == 'K'){
                if (kSize > 0){
                    kSize--;
                    result++;
                } else{
                    break;
                }
            } else{
                result++;
            }
        }

        System.out.print(result);

    }
}
