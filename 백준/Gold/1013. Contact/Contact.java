import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String vega = "(100+1+|01)+";
        int tc = sc.nextInt();
        
        for (int i = 0; i < tc; i++) {
            String spread = sc.next();
            if (spread.matches(vega)) System.out.println("YES");
            else System.out.println("NO");
        }
        
        sc.close();
    }
}