import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> fr;
    static int N, M, max;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        fr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            fr.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            fr.get(a).add(b);
            fr.get(b).add(a);
        }
        br.close();
        
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            max = Integer.MIN_VALUE;
            int tmp = dfs(i, 0);
            if (max >= 4){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    
    private static int dfs(int curr, int count) {
        if (count >= 4) {
            return count;
        }
        
        List<Integer> adj = fr.get(curr);
        for (Integer people : adj) {
            if (!visited[people]) {
                visited[people] = true;
                max = Math.max(dfs(people, count + 1), max);
                visited[people] = false;
            }
        }
        return count;
    }
}