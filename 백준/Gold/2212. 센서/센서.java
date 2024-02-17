import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] censor = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            censor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(censor);
        
        List<Integer> diff = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            diff.add(censor[i] - censor[i-1]);
        }
        
        if (diff.size() == 0) {
            System.out.println(0);
            return;
        }
        
        Collections.sort(diff, Collections.reverseOrder());
        for (int i = 0; i < K - 1; i++) {
            diff.remove(0);
        }
        
        int res = 0;
        for (int i = 0; i < diff.size(); i++) {
            res += diff.get(i);
        }
        System.out.println(res);
        br.close();
    }
}