import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Lecture[] lecs = new Lecture[N];
        int res = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int fee = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lecs[i] = new Lecture(day, fee);
        }
        br.close();
        
        Arrays.sort(lecs, (p1, p2) -> (p1.fee == p2.fee) ? p2.day - p1.day : p2.fee - p1.fee);
        
        boolean[] check = new boolean[10001];
        for (int i = 0; i < N; i++) {
            for (int j = lecs[i].day; j >= 1; j--) {
                if (!check[j]) {
                    check[j] = true;
                    res += lecs[i].fee;
                    break;
                }
            }
        }
        
        System.out.println(res);
    }
    
    static class Lecture implements Comparable<Lecture> {
        int day, fee;
        
        public Lecture(int day, int fee) {
            this.day = day;
            this.fee = fee;
        }
        
        @Override
        public int compareTo(Lecture o) {
            if (this.day == o.day) {
                return o.fee - this.fee;
            }
            return this.day - o.day;
        }
    }
}