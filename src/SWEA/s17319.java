package SWEA;

import java.io.*;

public class s17319 {
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Integer T = Integer.valueOf(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)	{
            Integer length = Integer.valueOf(br.readLine());
            String target = br.readLine();

            System.out.println(length % 2);

            if (length % 2 != 0) {
                sb.append("#").append(test_case).append(" No\n");
                break;
            }
            String forward = target.substring(target.length() / 2);
            String backward = target.substring(0, target.length() / 2);
            if (forward.compareTo(backward)==0) sb.append("#").append(test_case).append(" Yes\n");
            else sb.append("#").append(test_case).append(" No\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
}
