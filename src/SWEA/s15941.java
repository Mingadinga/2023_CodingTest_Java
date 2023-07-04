package SWEA;

import java.io.*;

public class s15941 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Integer T = Integer.valueOf(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            Integer target = Integer.valueOf(br.readLine());
            sb.append("#").append(test_case).append(" ").append(Math.round((Math.pow(target, 2)))).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
