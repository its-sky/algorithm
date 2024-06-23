import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        long[] accum = new long[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            accum[i] = arr[i];
            if (i > 0) {
                accum[i] += accum[i - 1];
            }
        }
        int start = 0;
        int end = M;
        long result = accum[end - 1];
        
        for (end = M; end < N; start++, end++) {
            result = Math.max(result, accum[end] - accum[start]);
        }
        
        System.out.println(result);
    }
}