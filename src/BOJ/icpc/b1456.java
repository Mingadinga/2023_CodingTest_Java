package BOJ.icpc;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b1456 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);

        // log2 b보다 작은 소수를 list에 담기
        int squareRoot = (int) Math.sqrt(max);
        List<Long> primes = new ArrayList<>();
        boolean[] visited = new boolean[squareRoot + 1];

        for (int i=2;i<=squareRoot;i++) {
            if (!visited[i]) {
                visited[i] = true;
                primes.add((long) i);
                for (int j=2*i;j<=squareRoot;j+=i) {
                    visited[j] = true;
                }
            }
        }

        // 거의 소수 판별
        long count = 0;
        for (Long prime: primes) {
            // min보다 큰 prime의 제곱수 중 가장 작은 수 - min
            // long start;
            long square = (long) Math.pow(prime, 2);
            for (long n=3;square<=max; n++) {
                if (square >= min) count++;
                square = (long) Math.pow(prime, n);
            }
        }
        System.out.println(count);

    }

}
