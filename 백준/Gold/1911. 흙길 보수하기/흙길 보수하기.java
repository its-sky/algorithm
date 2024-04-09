import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Info(s, e));
        }
        br.close();
        
        int res = 0;
        int fill = 0;
        while (!pq.isEmpty()) {
            Info curr = pq.poll();
            
            if (curr.e < fill) continue;
            
            if (fill < curr.s) fill = curr.s;
            
            int extra = (curr.e - fill) % L;
            
            res += (curr.e - fill) / L;
            fill = curr.e;
            
            if (extra != 0) {
                ++res;
                fill += L - extra;
            }
        }
        System.out.println(res);
    }
    
    static class Info implements Comparable<Info> {
        int s, e;
        
        public Info(int s, int e) {
            this.s = s;
            this.e = e;
        }
        
        @Override
        public int compareTo(Info o) {
            if (this.s == o.s) {
                return o.e - this.e;
            }
            return this.s - o.s;
        }
    }
}