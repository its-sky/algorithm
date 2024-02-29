import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        br.close();
        
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            res += (a + b);
            pq.add(a+b);
        }
        System.out.println(res);
    }
}