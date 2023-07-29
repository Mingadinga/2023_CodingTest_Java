package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2003 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;
    static int s = 0, e = 0;
    static int n = 0, m = 0;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        while(true) {
            if(sum >= m) sum -= numbers[s++];
            else if(e == n) break;
            else sum += numbers[e++];

            if(sum == m) count++;
        }

        System.out.println(count);

    }
}
