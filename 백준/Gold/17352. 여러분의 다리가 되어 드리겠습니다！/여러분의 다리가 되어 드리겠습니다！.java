import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        for (int i = 0; i < n - 2; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if (find(a) != find(b)) {
                union(a, b);
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (!isSameParent(1, i)) { 
                System.out.println(1 + " " + i);
                br.close();
                return;
            }
        }
    }
    
    public static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }
    
    public static int find(int x) {
        if (x == parent[x]) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a;
    }
}