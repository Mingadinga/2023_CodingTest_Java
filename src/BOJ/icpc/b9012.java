package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9012 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) sb.append(isRightVPS(br.readLine()) ? "YES\n" : "NO\n");
        System.out.print(sb);
    }

    private static boolean isRightVPS(String vps) {
        int temp = 0;
        for(int i=0;i<vps.length();i++) {
            char c = vps.charAt(i);
            if (c == '(') temp++;
            else if (c == ')' && temp > 0) temp--;
            else if (c == ')' && temp <= 0) return false;
        }
        return temp == 0;
    }

}
