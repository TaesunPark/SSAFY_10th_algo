package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        for (int t_c = 1; t_c <= n; t_c++){
            String str = br.readLine();
            String str2 = "";
            String str3 = "";
 
 
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == 'X'){
                    str2 += "1";
                }
                else if (str.charAt(i) == 'x'){
                    str2 += "0";
                } else{
                    str2 += str.charAt(i);
                }
            }
 
            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == 'X'){
                    str3 += "0";
                }
                else if (str.charAt(i) == 'x'){
                    str3 += "1";
                } else{
                    str3 += str.charAt(i);
                }
            }
            
            str2 = str2.trim();
            str3 = str3.trim();
            
            while (str2.length() > 1){            	
                str2 = change(str2);                
            }
            
            while (str3.length() > 1){                        	
                str3 = change(str3);                
            }
 
            if (str2.equals(str3)){
                System.out.println("#"+t_c+" 0");
            } else{
                System.out.println("#"+t_c+" 1");
            }
        }
 
    }
 
    public static String change(String str2){
        char[] arr1 = str2.toCharArray();        
        
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] == ')'){
                if (arr1[i-2] == '^'){
                    if (arr1[i-3] == arr1[i-1]){
                        arr1[i-4] = 'd';
                        arr1[i-3] = 'd';
                        arr1[i-2] = '0';
                        arr1[i-1] = 'd';
                        arr1[i] = 'd';
                    }else{
                        arr1[i-4] = 'd';
                        arr1[i-3] = 'd';
                        arr1[i-2] = '1';
                        arr1[i-1] = 'd';
                        arr1[i] = 'd';
                    }
                }
                else if (arr1[i-2] == '|'){
                    if (arr1[i-3] == '0' && arr1[i-1] == '0'){
                        arr1[i-4] = 'd';
                        arr1[i-3] = 'd';
                        arr1[i-2] = '0';
                        arr1[i-1] = 'd';
                        arr1[i] = 'd';
                    }else{
                        arr1[i-4] = 'd';
                        arr1[i-3] = 'd';
                        arr1[i-2] = '1';
                        arr1[i-1] = 'd';
                        arr1[i] = 'd';
                    }
                }
                else if (arr1[i-2] == '&'){
                    if (arr1[i-3] == '0' || arr1[i-1] == '0'){
                        arr1[i-4] = 'd';
                        arr1[i-3] = 'd';
                        arr1[i-2] = '0';
                        arr1[i-1] = 'd';
                        arr1[i] = 'd';
                    }else{
                        arr1[i-4] = 'd';
                        arr1[i-3] = 'd';
                        arr1[i-2] = '1';
                        arr1[i-1] = 'd';
                        arr1[i] = 'd';
                    }
                }
                break;
            }
        }
 
        str2 = "";
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] == 'd'){
                continue;
            }
            str2 += arr1[i];
        }
        str2 = str2.trim();
 
        return str2;
 
    }
}
