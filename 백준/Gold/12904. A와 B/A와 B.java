import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String A = br.readLine();
        String B = br.readLine();
        br.close();
        
        while (A.length() < B.length()) {
            StringBuffer sb = new StringBuffer();
            if (B.endsWith("A")) {
                B = B.substring(0, B.length() - 1);
            } else if (B.endsWith("B")) {
                B = B.substring(0, B.length() - 1);
                B = sb.append(B).reverse().toString();
            }
        }
        
        if (A.equals(B)) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}