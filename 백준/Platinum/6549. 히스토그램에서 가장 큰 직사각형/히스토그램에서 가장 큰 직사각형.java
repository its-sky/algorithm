import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            
            if (N == 0) {
                break;
            }
            arr = new long[N + 2];
            for (int i = 1; i < N + 1; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            
            Stack<Integer> s = new Stack<>();
            s.push(0);
            long res = 0;
            
            for (int i = 1; i < N + 2; i++) {
                while (!s.isEmpty()) {
                    int top = s.peek();
                    if (arr[top] <= arr[i]) break;
                    s.pop();
                    res = Math.max(res, arr[top] * (i - s.peek() - 1));
                }
                s.push(i);
            }
            System.out.println(res);
        }
        br.close();
    }
}