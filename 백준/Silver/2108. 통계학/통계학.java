import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        int num1 = Math.round(sum / (float)N);
        int num2 = arr[arr.length / 2];
        int num4 = arr[N - 1] - arr[0];
        
        int count = -1;
        for (Integer key : map.keySet()) {
            count = Math.max(count, map.get(key));
        }
        
        List<Integer> countMaxList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == count) {
                countMaxList.add(key);
            }
        }
        Collections.sort(countMaxList);
        int num3 = 0;
        if (countMaxList.size() > 1) {
            num3 = countMaxList.get(1);
        } else {
            num3 = countMaxList.get(0);
        }
        
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);

    }
}