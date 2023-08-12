package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1300 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());

        long start = 1, end = (long) Math.pow(n, 2), mid = 1, result = 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (countOfEqualOrLessNumber(mid, n) >= k) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static long countOfEqualOrLessNumber(long target, int n) {
        long result = 0;
        for (int i=1;i<=n;i++) {
            long temp = target / i;
            temp = temp > n ? n : temp;
            result += temp;
        }
        return result;
    }
}
