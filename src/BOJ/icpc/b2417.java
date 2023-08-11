package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class b2417 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long target = Long.parseLong(br.readLine());
        System.out.print(sqrt(target));
    }

    static String sqrt(long n){
        long start = 0;
        long end = n;
        long mid = 0;
        long result = 0;

        while(start <= end) {
            mid = (start + end) / 2;
            if (n <= Math.pow(mid, 2)) {
                end = mid - 1;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        return new BigDecimal(result).toString();
    }
}
