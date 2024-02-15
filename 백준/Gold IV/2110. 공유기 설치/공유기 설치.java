import java.io.*;
import java.util.*;

public class Main {
    static int C, res = 0;
    static int[] router;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        router = new int[N];
        for (int i = 0; i < N; i++) {
            router[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(router);
        
        binarySearch(1, router[router.length - 1] - router[0]);
        System.out.println(res);
        br.close();
    }
    
    private static void binarySearch(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int curr = router[0];
            int cnt = 1;
            
            for (int i = 1; i < router.length; i++) {
                if (router[i] >= curr + mid) {
                    ++cnt;
                    curr = router[i];
                }
            }
            if (cnt >= C) {
                start = mid + 1;
                res = mid;
            } else {
                end = mid - 1;
            }
        }
    }
}