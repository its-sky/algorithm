import java.io.*;
import java.util.*;

public class Main {
    static int G, P;
    static int[] parent;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        check = new boolean[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        
        int target = 0;
        int res = 0;
        for (int i = 0; i < P; i++) {
            target = Integer.parseInt(br.readLine());
            int emptyGate = find(target);
            
            if (emptyGate == 0) break;
            
            ++res;
            union(emptyGate, emptyGate - 1);
        }
        br.close();
        
        System.out.println(res);
    }
    
    private static int find(int idx) {
        if (parent[idx] == idx) return idx;
        return parent[idx] = find(parent[idx]);
    }
    
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) parent[a] = b;
    }
}