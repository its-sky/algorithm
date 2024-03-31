import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        int tmp = 0;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(st.nextToken());
            if (tmp < 0) minus.add(tmp);
            else plus.add(tmp);
        }
        br.close();
        int res = 0;
        
        Collections.sort(minus);
        Collections.sort(plus, Collections.reverseOrder());
        
        if (minus.size() > 0) {
            if (plus.size() > 0) {
                // 둘다 있음
                if (Math.abs(minus.get(0)) > plus.get(0)) {
                    // minus 우세
                    res += Math.abs(minus.get(0));
                    for (int i = M; i < minus.size(); i += M) {
                        res += (2 * Math.abs(minus.get(i)));
                    }
                    for (int i = 0; i < plus.size(); i += M) {
                        res += (2 * plus.get(i));
                    }
                } else {
                    // plus, minus 같거나 우세
                    res += plus.get(0);
                    for (int i = M; i < plus.size(); i += M) {
                        res += (2 * plus.get(i));
                    }
                    for (int i = 0; i < minus.size(); i += M) {
                        res += (2 * Math.abs(minus.get(i)));
                    }
                }
            } else {
                res += Math.abs(minus.get(0));
                for (int i = M; i < minus.size(); i += M) {
                    res += (2 * Math.abs(minus.get(i)));
                }
            }
        } else {
            res += plus.get(0);
            for (int i = M; i < plus.size(); i += M) {
                res += (2 * plus.get(i));
            }
        }
        System.out.println(res);
    }
}