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
        br.close();
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < N; i++) {
            while (stack.size() > 0 && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                res[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        
        System.out.print(res[0]);
        for (int i = 1; i < N; i++) {
            System.out.print(" " + res[i]);
        }
    }
}