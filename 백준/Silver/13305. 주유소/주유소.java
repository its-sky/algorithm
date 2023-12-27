import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        long[] dist = new long[n - 1];
        long[] gas = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gas[i] = Long.parseLong(st.nextToken());
        }
        
        long cost = gas[0] * dist[0];
        long curr_dist = 0;
        long target = 0;
        if (gas[0] < gas[1]) target = gas[0];
        else target = gas[1];
        for (int i = 2; i < n; i++) {
            if (gas[i] >= target) {
                curr_dist += dist[i - 1];
            } else if (gas[i] < target) {
                cost += (curr_dist + dist[i - 1]) * target;
                target = gas[i];
                curr_dist = 0;
            }
        }
        if (curr_dist != 0) cost += curr_dist * target;
        System.out.println(cost);
        br.close();
    }
}