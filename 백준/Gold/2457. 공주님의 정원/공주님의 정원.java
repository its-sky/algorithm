import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
        StringTokenizer st;
        Flower[] flowers = new Flower[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            
            int start = sm * 100 + sd;
            int end = em * 100 + ed;
            flowers[i] = new Flower(start, end);
        }
        br.close();
        
        Arrays.parallelSort(flowers);
        
        int endDay = 1201;
        int start = 301;
        int count = 0;
        int max = 0;
        int index = 0;
        
        while (start < endDay) {
            boolean isFinded = false;
            
            for (int i = index; i < N; i++) {
                if (flowers[i].start > start) {
                    break;
                }
                
                if (max < flowers[i].end) {
                    isFinded = true;
                    max = flowers[i].end;
                    index = i + 1;
                }
            }
            
            if (isFinded) {
                start = max;
                ++count;
            } else {
                break;
            }
        }
        
        if (max < endDay) {
            System.out.println(0);
        } else {
            System.out.println(count);
        }
    }
    
    static class Flower implements Comparable<Flower> {
        int start;
        int end;
        
        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        // 1. 시작일 낮은 순
        // 2. 종료일 높은 순
        @Override
        public int compareTo(Flower f) {
            if (this.start < f.start) {
                return -1;
            } else if (this.start == f.start) {
                if (this.end > f.end) return -1;
                else if (this.end == f.end) return 0;
                return 1;
            } else {
                return 1;
            }
        }
    }
}