import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new int[]{d, w});
        }
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        Queue<Integer> q = new PriorityQueue<>();
        for (int[] p : list) {
            q.offer(p[1]);
            if (q.size() > p[0]) {
                q.poll();
            }
        }
        
        int total = 0;
        while (!q.isEmpty()) {
            total += q.poll();
        }
        System.out.println(total);
    }
}