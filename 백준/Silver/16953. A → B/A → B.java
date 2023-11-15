import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        long a = Long.parseLong(inputs[0]);
        long b = Long.parseLong(inputs[1]);
        
        System.out.println(bfs(a, b));
        br.close();
    }
    
    private static long bfs(long a, long b) {
        Queue<Status> q = new LinkedList<>();
        q.offer(new Status(a, 1));
        
        while (!q.isEmpty()) {
            Status curr = q.poll();
            
            if (curr.num == b) {
                return curr.count;
            }
            if (curr.num*10+1 <= b) q.offer(new Status(curr.num * 10 + 1, curr.count + 1));
            if (curr.num*2 <= b) q.offer(new Status(curr.num * 2, curr.count + 1));
        }
        return -1l;
    }
    
    static class Status {
        public long num, count;
        
        public Status(long num, long count) {
            this.num = num;
            this.count = count;
        }
    }
}