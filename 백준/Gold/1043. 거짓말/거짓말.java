import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean[] knows = new boolean[n + 1];
        
        HashSet<Integer>[] parties = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            parties[i] = new HashSet<>();
        }
        
        String[] inputs = br.readLine().split(" ");
        int count = Integer.parseInt(inputs[0]);
        
        for (int i = 1; i <= count; i++) {
            int tmp = Integer.parseInt(inputs[i]);
            knows[tmp] = true;
        }
        
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        for (int p = 1; p <= m; p++) {
            inputs = br.readLine().split(" ");
            int party_num = Integer.parseInt(inputs[0]);
            
            if (party_num <= 1) {
                parties[p].add(Integer.parseInt(inputs[1]));
                continue;
            }
            
            for (int j = 1; j < party_num; j++) {
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j + 1]);
                if (find(a) != find(b)) union(a, b);
                
                parties[p].add(a);
                parties[p].add(b);
            }
        }
        
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (knows[i] && !visited[i]) {
                int root = find(i);
                for (int j = 1; j <= n; j++) {
                    if (find(j) == root) {
                        knows[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }
        
        int res = 0;
        for (int i = 1; i <= m; i++) {
            boolean flag = false;
            for (int person : parties[i]) {
                if (knows[person]) {
                    flag = true;
                    break;
                }
            }
            
            if (!flag) ++res;
        }
        System.out.println(res);
        br.close();
    }
    
    public static int find(int idx) {
        if (parent[idx] == idx) return idx;
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }
    
    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a;
    }
}