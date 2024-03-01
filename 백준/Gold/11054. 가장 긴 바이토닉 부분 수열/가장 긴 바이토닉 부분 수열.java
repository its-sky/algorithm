import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] input = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        int[] ldp = new int[N];
        int[] rdp = new int[N];
        
        Arrays.fill(ldp, 1);
        Arrays.fill(rdp, 1);
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    ldp[i] = Math.max(ldp[i], ldp[j] + 1);
                }
            }
        }
        
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    rdp[i] = Math.max(rdp[i], rdp[j] + 1);
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, ldp[i] + rdp[i]);
        }
        System.out.println(res - 1);
        
    }
}