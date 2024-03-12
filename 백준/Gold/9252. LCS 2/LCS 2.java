import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length()+1][b.length()+1];
        
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        br.close();
        
        int x = a.length();
        int y = b.length();
        StringBuilder sb = new StringBuilder();
        
        while (dp[x][y] != 0) {
            if (dp[x][y] != dp[x-1][y] && dp[x][y] != dp[x][y-1]) {
                x -= 1;
                y -= 1;
                sb.append(b.charAt(y));
            } else {
                if (dp[x-1][y] > dp[x][y-1]) {
                    x -= 1;
                } else {
                    y -= 1;
                }
            }
        }
        
        System.out.println(dp[a.length()][b.length()]);
        System.out.println(sb.reverse());
    }
}