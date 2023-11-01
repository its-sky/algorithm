import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class World {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[16];
        dp[0] = 2;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (int)(Math.pow(2, i-1));
        }

        System.out.println((int)(Math.pow(dp[n],2)));
    }
}
