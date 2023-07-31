package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14731 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            sum = (sum + (((long) c * k) % mod) * pow(2, k-1)) % mod;
        }

        System.out.printf("%d\n", sum);

    }

    private static long pow(int bottom, long exponent) {

        if (exponent == 0) return 1L;
        else if (exponent == 1) return bottom;

        long temp = pow(bottom, exponent / 2);

        if (exponent % 2 != 0) {
            return (temp * temp % mod) * bottom % mod;
        }

        return temp * temp % mod;

    }
}
