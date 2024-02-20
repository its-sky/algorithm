import java.io.*;
import java.util.*;

public class Main {
    static int N, res;
    static boolean[] isIt;
    static List<Integer> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        res = 0;
        br.close();
        
        isIt = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) arr.add(i);
        }
        
        getResult();
    }
    
    private static boolean isPrime(int num) {
        int target = (int)Math.sqrt(num);
        
        for (int i = 2; i <= target; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    private static void getResult() {
        int start = 0;
        int end = 0;
        int currNum = 2;
        int idx = 0;
        while (start < arr.size() && end < arr.size()) {
            if (currNum < N) {
                ++end;
                if (arr.size() <= end) break;
                currNum += arr.get(end);
            } else if (currNum == N) {
                ++res;
                currNum -= arr.get(start++);
            } else {
                currNum -= arr.get(start++);
            }
        }
        
        System.out.println(res);
    }
}