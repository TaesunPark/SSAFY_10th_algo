import java.util.*;
import java.io.*;
public class Main {

    public static HashMap<Character, Integer> hashMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        hashMap = new HashMap<>();
        int len = str.length();
        char[] values = new char[len];

        for (int i = 0; i < str.length(); i++){
            hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        Iterator<Character> iterator = hashMap.keySet().iterator();
        ArrayList<Character> list = new ArrayList<>();

        while (iterator.hasNext()){
            list.add(iterator.next());
        }

        Collections.sort(list);
        int idx = 0;

        for (int i = 0; i < list.size(); i++){
            if (check(list.get(i))){
                values[idx] = list.get(i);
                values[len - idx - 1] = list.get(i);
                hashMap.put(list.get(i), hashMap.get(list.get(i)) - 2);
                idx++;
                i--;
            }
        }

        if (len % 2 != 0){
            for (Character value : hashMap.keySet()){
                if (hashMap.get(value) > 0){
                    values[len / 2] = value;
                }
            }
        }

        if (idx != len / 2){
            System.out.print("I'm Sorry Hansoo");
            return;
        }
        for (int i = 0; i < len; i++){
            System.out.print(values[i]);
        }

    }

    public static boolean check(char value){
        if (hashMap.get(value) < 2) return false;
        return true;
    }
}

