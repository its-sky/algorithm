import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        int[] alpha = new int[26];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        for (int i = 0; i < N; i++) {
            int temp = (int)Math.pow(10, arr[i].length() - 1);
            for (int j = 0; j < arr[i].length(); j++) {
                alpha[(int)arr[i].charAt(j)-65] += temp;
                temp /= 10;
            }
        }
        
        Arrays.sort(alpha);
        int idx = 9;
        int sum = 0;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) break;
            sum += alpha[i]*idx;
            --idx;
        }
        System.out.println(sum);
    }
    
}