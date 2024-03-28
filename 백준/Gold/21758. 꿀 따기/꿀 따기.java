import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long total, maxCount;
    static int[] honeys;
    static long[] toRightTotal, toLeftTotal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        honeys = new int[N];
        toRightTotal = new long[N];
        toLeftTotal = new long[N];
        long temp = 0;
        
        for (int i = 0; i < N; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            temp += honeys[i];
            toRightTotal[i] = temp;
        }
        
        temp = 0;
        for (int i = N - 1; i >= 0; i--) {
            temp += honeys[i];
            toLeftTotal[i] = temp;
        }
        
        total = toRightTotal[N - 1];
        
        case1();
        case2();
        case3();
        
        System.out.println(maxCount);
        br.close();
    }
    
    static void case1() {
        long bee1, bee2;
        
        for (int i = 1; i <= N - 2; i++) {
            bee1 = total - honeys[0] - honeys[i];
            bee2 = total - toRightTotal[i];
            maxCount = Math.max(maxCount, bee1 + bee2);
        }
    }
    
    static void case2() {
        long bee1, bee2;
        
        for (int i = N - 2; i >= 1; i--) {
            bee1 = total - honeys[N - 1] - honeys[i];
            bee2 = total - toLeftTotal[i];
            maxCount = Math.max(maxCount, bee1 + bee2);
        }
    }
    
    static void case3() {
        long bee1, bee2;
        
        for (int i = 1; i <= N - 2; i++) {
            bee1 = toRightTotal[i] - honeys[0];
            bee2 = toLeftTotal[i] - honeys[N - 1];
            maxCount = Math.max(maxCount, bee1 + bee2);
        }
    }
}