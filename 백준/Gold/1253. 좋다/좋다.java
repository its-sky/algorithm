import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        if (N <= 2) {
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while (true) {
                if (left == i) ++left;
                else if (right == i) --right;
                
                if (left >= right) break;
                
                if (arr[left] + arr[right] > arr[i]) --right;
                else if (arr[left] + arr[right] < arr[i]) ++left;
                else {
                    ++res;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}