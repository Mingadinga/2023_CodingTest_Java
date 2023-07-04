package SWEA;

import java.io.*;

public class s10726 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer T = Integer.valueOf(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] input = br.readLine().split(" ");
            Integer n = Integer.valueOf(input[0]); Integer m = Integer.valueOf(input[1]);
            int end = (int) Math.pow(2, n);
            String result = m % end == end-1 ? "ON" : "OFF";
            sb.append("#").append(test_case).append(" ")
                    .append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);

    }
}
