import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();
        
        List<Integer> list = new ArrayList<>();
        
        list.add(Integer.MIN_VALUE);
        
        for (int i = 1; i <= N; i++) {
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;
            
            if (num > list.get(list.size() - 1)) list.add(num);
            else {
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
            }
        }
        System.out.println(list.size() - 1);
    }
}