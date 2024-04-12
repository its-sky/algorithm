import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }
            
            long res = 0;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                long input = a + b;
                res += input;
                pq.offer(input);
            }
            sb.append(res).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}