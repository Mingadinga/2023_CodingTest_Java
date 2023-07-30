package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b17087 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        int[] aList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(aList).map(a -> Math.abs(a - s)).toArray();

        System.out.printf("%d\n", gcd(numbers));
    }

    private static int gcd(int[] numbers) {
        if (numbers.length < 2) return numbers[0];

        int temp = gcd(numbers[0], numbers[1]);
        if (numbers.length > 2) {
            for (int i = 2; i < numbers.length; i++) {
                temp = gcd(temp, numbers[i]);
            }
        }
        return temp;

//        while(true) {
//            if (numbers.length == 2) return gcd(numbers[0], numbers[1]);
//            return gcd(gcd(Arrays.copyOfRange(numbers, 0, numbers.length-2)), numbers[numbers.length-1]);
//        }

    }

    private static int gcd(int a, int b) {
        int r;
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
