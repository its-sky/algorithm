import java.io.*;
import java.util.*;

// ->, i / 1칸씩
// ->, i, <-, i / <-, l, <-, ;
// 마지막부터 한칸 추가해서 붙이면 됨

public class Main {
    static int[][] map = new int[101][101];
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            
            int[] dirs = makeDirections(d, g);
            
            map[x][y] += 1;
            for (int dr = 0; dr < dirs.length; dr++) {
                x += dx[dirs[dr]];
                y += dy[dirs[dr]];
                map[x][y] += 1;
            }
        }
        br.close();
        
        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (check(i, j)) {
                    ++result;
                }
            }
        }
        System.out.println(result);
    }
    
    private static boolean check(int x, int y) {
        if (map[x][y] > 0 && map[x][y + 1] > 0 && map[x + 1][y] > 0 && map[x + 1][y + 1] > 0) {
            return true;
        }
        return false;
    }
    
    private static int[] makeDirections(int dir, int gen) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerFirst(dir);
        int currGen = 0;
        
        while (currGen < gen) {
            int size = dq.size();
            Queue<Integer> tempQueue = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                int dr = dq.pollLast();
                tempQueue.offer((dr + 1) % 4);
                dq.offerFirst(dr);
            }
            while (!tempQueue.isEmpty()) {
                dq.offerLast(tempQueue.poll());
            }
            ++currGen;
        }
        int[] result = new int[dq.size()];
        int idx = 0;
        while (!dq.isEmpty()) {
            result[idx++] = dq.pollFirst();
        }
        return result;
    }
}