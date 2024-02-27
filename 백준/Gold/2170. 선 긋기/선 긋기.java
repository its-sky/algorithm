import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>();
        StringTokenizer st;
        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            pq.offer(new Line(x, y));
        }
        br.close();
        
        Line curr = pq.poll();
        int min = curr.x;
        int max = curr.y;
        int len = max - min;
        while (!pq.isEmpty()) {
            Line tmp = pq.peek();
            if (min <= tmp.x && tmp.y <= max) {
                pq.poll();
                continue;
            }
            else if (tmp.x < max) {
                len += tmp.y - max;
            } else {
                len += tmp.y - tmp.x;
            }
            min = tmp.x;
            max = tmp.y;
            pq.poll();
        }
        System.out.println(len);
    }
    
    static class Line implements Comparable<Line> {
        int x, y;
        
        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Line o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}