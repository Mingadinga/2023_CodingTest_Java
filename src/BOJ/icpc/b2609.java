package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2609 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int gcd = gcd(a, b);
        int lcm = lcm(a, b, gcd);

        System.out.printf("%d\n%d\n", gcd, lcm);
    }

    private static int gcd(int a, int b) {
        int r;
        while(b!=0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
