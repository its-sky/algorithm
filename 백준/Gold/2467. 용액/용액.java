import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = arr.length - 1;
        int currVal = Math.abs(arr[r] + arr[l]);
        int[] curr = new int[2];
        curr[0] = arr[l];
        curr[1] = arr[r];
        while (l+1 < r) {
            int a = diff(arr[l+1], arr[r]);
            int b = diff(arr[l], arr[r-1]);
            if (a <= b) {
                l += 1;
                if (a < currVal) {
                    currVal = a;
                    curr[0] = arr[l];
                    curr[1] = arr[r];
                }
            }
            else if (a > b) {
                r -= 1;
                if (b < currVal) {
                    currVal = b;
                    curr[0] = arr[l];
                    curr[1] = arr[r];
                }
            }
        }
        
        System.out.println(curr[0] + " " + curr[1]);
    }
    
    private static int diff(int a, int b) {
        return Math.abs(a + b);
    }
    
}