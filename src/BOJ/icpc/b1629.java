package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class b1629 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int c;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        System.out.println(pow(a, b));
    }

    private static long pow(long bottom, long exponent) {

        if (exponent == 1) {
            return bottom % c;
        }

        long temp = pow(bottom, exponent / 2);

        if (exponent % 2 != 0) {
            return (temp * temp % c * bottom) % c;
        }

        return temp * temp % c;

    }
}
