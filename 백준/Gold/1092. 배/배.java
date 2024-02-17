import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> crane;
    static List<Integer> box;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        
        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }
        
        int res = 0;
        
        while (!box.isEmpty()) {
            int idx = 0;
            for (int i = 0; i < N; ) {
                if (idx == box.size()) break;
                else if (crane.get(i) >= box.get(idx)) {
                    box.remove(idx);
                    ++i;
                } else ++idx;
            }
            ++res;
        }
        
        System.out.println(res);
        br.close();
    }
}