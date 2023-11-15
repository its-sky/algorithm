import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        
        st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n - 1];
        int curr = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n - 1; i++) {
            int comp = Integer.parseInt(st.nextToken());
            arr[i] = comp - curr;
            curr = comp;
        }
        Arrays.sort(arr);
        long res = 0l;
        for (int i = 0; i < n - 1 - k; i++) {
            res += arr[i];
        }
        System.out.println(res);
        br.close();
    }
}