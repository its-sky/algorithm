import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] inputs = br.readLine().split(" ");
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        
        if (N == 1 || (N == 2 && arr[0] != arr[1])) {
            System.out.println("A");
        } else if (N == 2) {
            System.out.println(arr[0]);
        } else {
            int a, b;
            if (arr[1] == arr[0]) {
                a = 1;
                b = 0;
            } else {
                a = (arr[2] - arr[1]) / (arr[1] - arr[0]);
                b = arr[1] - (arr[0] * a);
            }
            
            int i = 1;
            for (; i < N; i++) {
                if (arr[i] != (arr[i - 1]*a + b)) break;
            }
            if (i != N) {
                System.out.println("B");
            } else {
                System.out.println((arr[N - 1]*a + b));
            }
        }
        
    }
}