package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        System.out.println(factorial(n) / (factorial(n-k) * factorial(k)));

    }

    private static int factorial(int n) {
        int result = 1;
        for(int i=2;i<=n;i++) result *= i;
        return result;
    }

}
