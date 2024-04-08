import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < N; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = e - s;
            int max = (int)Math.sqrt(d);
            
            if (max == Math.sqrt(d)) {
                sb.append(max * 2 - 1).append("\n");
            } else if (d <= max * max + max) {
                sb.append(max * 2).append("\n");
            } else {
                sb.append(max *2 + 1).append("\n");
            }
        }
        br.close();
        System.out.println(sb);
    }
}