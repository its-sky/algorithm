import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[n];
        int LIS = 0;
        
        for (int i = 0; i < n; i++) {
            int idx = BinarySearch(arr[i], 0, LIS, LIS + 1);
            
            if (idx == -1) {
                dp[LIS++] = arr[i];
            } else {
                dp[idx] = arr[i];
            }
        }
        
        System.out.println(LIS);
        br.close();
    }
    
    private static int BinarySearch(int num, int start, int end, int size) {
        int res = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (num <= dp[mid]) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        if (start == size) {
            return -1;
        } else {
            return res;
        }
    }
}