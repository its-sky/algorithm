import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            char[] ops = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            
            st = new StringTokenizer(br.readLine(), "[],");
            
            for (int i = 0; i < N; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }
            
            AC(ops, deque);
        }
        br.close();
        
        System.out.println(sb);
    }
    
    private static void AC(char[] ops, ArrayDeque<Integer> deque) {
        boolean isRight = true;
        
        for (char op : ops) {
            if (op == 'R') {
                isRight = !isRight;
                continue;
            }
            
            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }
        
        make(deque, isRight);
    }
    
    private static void make(ArrayDeque<Integer> deque, boolean isRight) {
        sb.append('[');
        
        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }
        
        sb.append(']').append('\n');
    }

}