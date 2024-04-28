import java.util.*;
import java.io.*;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new long[N+1];

        for(int i = 2; i < N+1; i++)
            arr[i] = -1;

        arr[0] = 0;
        arr[1] = 1;

        System.out.println(fibonacci(N));

    }

    static long fibonacci(int N) {

        if(arr[N] == -1) {
            arr[N] = fibonacci(N - 1) + fibonacci(N - 2);
        }

        return arr[N];
    }

}