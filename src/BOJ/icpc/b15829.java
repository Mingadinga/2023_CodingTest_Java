package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15829 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static int M = 1_234_567_891;
    final static int R = 31;

    public static void main(String[] args) throws IOException {
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long sum = 0, pow = 1;
        for (int i = 0; i < l; i++) {
            sum += (s.charAt(i) - 'a' + 1) * pow;
            pow = (pow * R) % M;
        }
        System.out.println(sum % M);
    }
}
