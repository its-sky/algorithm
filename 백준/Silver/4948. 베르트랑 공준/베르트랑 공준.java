import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            
            int count = 0;
            for (int i = N + 1; i <= 2 * N; i++) {
                if (check(i)) ++count;
            }
            System.out.println(count);
        }
    }
    
    private static boolean check(int num) {
        for (int i = 2; i <= (int)(Math.sqrt(num + 1)); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}