import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        int[] gas = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }
        
        int cost = gas[0] * dist[0];
        int curr_dist = 0;
        int target = 0;
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