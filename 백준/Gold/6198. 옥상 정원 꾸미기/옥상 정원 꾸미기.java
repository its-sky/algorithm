import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long[] count = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Stack<Integer> stack = new Stack<>();
        
        stack.push(N - 1);
        for (int i = N - 2; i >= 0; i--) {
            while (stack.size() > 0 && arr[stack.peek()] < arr[i]) {
                count[i] += count[stack.pop()] + 1;
            }
            stack.push(i);
        }
        
        long res = 0;
        for (int i = 0; i < N; i++) {
            res += count[i];
        }
        System.out.println(res);
    }
}