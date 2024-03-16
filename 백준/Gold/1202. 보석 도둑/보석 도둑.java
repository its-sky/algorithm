import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        Gem[] gems = new Gem[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gems[i] = new Gem(m, v);
        }
        
        Arrays.sort(gems, new Comparator<Gem>() {
            @Override
            public int compare(Gem o1, Gem o2) {
                if (o1.m == o2.m) {
                    return o2.v - o1.v;
                }
                return o1.m - o2.m;
            }
        });
        
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && gems[j].m <= bags[i]) {
                pq.add(gems[j++].v);
            }
            
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        
        System.out.println(ans);
        br.close();
    }
    
    static class Gem {
        int m, v;
        
        public Gem(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}