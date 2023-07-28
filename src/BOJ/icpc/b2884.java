package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2884 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        final int h = Integer.parseInt(input[0]);
        final int m = Integer.parseInt(input[1]);

        int result_h = h;
        int result_m = m;

        result_m -= 45;
        if (result_m < 0) {
            result_m += 60;
            result_h -= 1;
        }
        if(result_h < 0) {
            result_h += 24;
        }

        System.out.printf("%d %d\n", result_h, result_m);
    }
}
