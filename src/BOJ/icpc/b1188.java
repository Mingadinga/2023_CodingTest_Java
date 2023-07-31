package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1188 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        if (n % m == 0) System.out.println(0);
        else System.out.println(m - gcd(n, m));

    }

    private static int gcd(int a, int b) {
        int r;
        while(b!=0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

}
