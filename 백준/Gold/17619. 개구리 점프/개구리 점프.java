import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        Log[] arr = new Log[N + 1];
        parent = new int[N + 1];
        size = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        arr[0] = new Log(-1, -1, -1);
        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int x2 = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);
            arr[i] = new Log(x1, x2, i);
        }
        
        Arrays.sort(arr);
        
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (arr[i].x2 >= arr[j].x1) {
                    union(arr[i].idx, arr[j].idx);
                } else {
                    break;
                }
            }
        }
        
        for (int i = 0; i < Q; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            if (find(x) == find(y)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        br.close();
    }
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        int r1 = find(x);
        int r2 = find(y);
        
        if (size[r1] > size[r2]) {
            int tmp = r1;
            r1 = r2;
            r2 = tmp;
        }
        
        parent[r1] = r2;
        size[r2] += size[r1];
    }
    
    static class Log implements Comparable<Log> {
        int x1, x2, idx;
        
        public Log(int x1, int x2, int idx) {
            this.x1 = x1;
            this.x2 = x2;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Log o) {
            return this.x1 - o.x1;
        }
        
    }
    
}