import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        List<Homework> arr = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int day = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            arr.add(new Homework(day, count));
        }
        br.close();
        
        Collections.sort(arr);
        
        for (int i = 0; i < N; i++) {
            int day = arr.get(i).day;
            int count = arr.get(i).count;
            pq.offer(count);
            if (day < pq.size()) {
                pq.poll();
            }
        }
        
        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
            
        }
        System.out.println(res);
    }
    
    static class Homework implements Comparable<Homework> {
        int day, count;
        
        public Homework(int day, int count) {
            this.day = day;
            this.count = count;
        }
        
        @Override
        public int compareTo(Homework o) {
            if (this.day == o.day) {
                return o.count - this.count;
            }
            return this.day - o.day;
        }
    }
}