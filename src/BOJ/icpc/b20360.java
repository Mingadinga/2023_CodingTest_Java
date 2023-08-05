package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b20360 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String binaryString = Integer.toBinaryString(n);

        int length = binaryString.length();
        for (int i=length-1;i>=0;i--) {
            if (binaryString.charAt(i) == '1') {
                sb.append(length-i-1).append(" ");
            }
        }
        System.out.println(sb);
    }
}
