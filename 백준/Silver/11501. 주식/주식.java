import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            long res = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int target = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (target > arr[i]) res += target - arr[i];
                else if (target < arr[i]) target = arr[i];
            }
            System.out.println(res);
        }
        br.close();
    }
}