import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(input);
            }
        }
        br.close();
        
        int sum = 0;
        
        while (stack.size() > 0) {
            sum += stack.pop();
        }
        
        System.out.println(sum);
    }
}