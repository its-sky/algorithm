import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = parse(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int min = 50;
        int idx = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = parse(st.nextToken());
            
            if (min >= arr[i]) {
                min = arr[i];
                idx = i;
            }
        }
        int money = parse(br.readLine());
        char[] digits = new char[51];
        int cnt = 0;
        while (money >= min) {
            digits[cnt++] = (char) (idx + '0');
            money -= min;
        }
        
        int start = 0;
        for (int i = 0; i < cnt; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (money + min >= arr[j]) {
                    digits[i] = (char) (j + '0');
                    money += min - arr[j];
                    break;
                }
            }
            
            if (digits[start] == '0') {
                ++start;
                money += min;
            }
        }
        
        br.close();
        
        if (start == cnt) {
            System.out.println(0);
            return;
        }
        
        String ans = "";
        for (int i = start; i < cnt; i++) {
            ans += digits[i];
        }
        System.out.println(ans);
    }
    
    private static int parse(String num) {
        return Integer.parseInt(num);
    }
}