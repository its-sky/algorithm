import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] res, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new int[m];
        
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        
        dfs(0, 0, sb);
        
        System.out.println(sb.toString());
        
        br.close();
    }
    
    private static void dfs(int start, int cnt, StringBuilder sb) {
        if (cnt == m) {
           for (int i = 0; i < m; i++) {
               sb.append(res[i] + " ");
           }
           sb.append("\n");
        } else {
            int num = 0;
            for (int i = start; i < n; i++) {
                if (num == arr[i]) continue;
                
                res[cnt] = arr[i];
                dfs(i, cnt + 1, sb);
                num = arr[i];
            }
        }
    }
}