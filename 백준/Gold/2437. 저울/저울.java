import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(weight);
        
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (sum + 1 < weight[i]) {
                break;
            }
            
            sum += weight[i];
        }
        
        System.out.println(sum + 1);
    }
}