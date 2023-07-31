package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1016 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);
        int size = (int) (max - min + 1);

        boolean[] isMultipleOfSquare = new boolean[size];
        for (long i=2;i<=Math.sqrt(max);i++) {
            long square = i * i;
            long start = min % square == 0 ? min / square : (min / square) + 1;
            for (long j=start;j*square<=max;j++) {
                isMultipleOfSquare[(int) ((j * square) - min)] = true;
            }
        }

        int count = 0;
        for (boolean b: isMultipleOfSquare) {
            if (!b) count++;
        }
        System.out.println(count);
    }
}
