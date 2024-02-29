import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long res = 0;

        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        br.close();
        
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            res += (a + b);
            pq.add(a+b);
        }
        System.out.println(res);
    }
}