import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int res = 0;
        
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
        br.close();
    }
}