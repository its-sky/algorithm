import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int l = 0, r = N - 1;
            int res = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr[mid] == target) {
                    res = mid;
                    r = mid - 1;
                } else if (arr[mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}