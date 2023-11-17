package BOJ.e_dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-1106-%EC%9E%90%EB%B0%94-java-%ED%98%B8%ED%85%94

public class b1106 {

    static int c, n;
    static int [] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        c = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        dp= new int [c+101];
        Arrays.fill(dp,987654321);
        dp[0]=0;

        for(int i=0; i<n; i++){
            String[] s1 = br.readLine().split(" ");
            int cost = Integer.parseInt(s1[0]);
            int people = Integer.parseInt(s1[1]);
            for(int j=people; j<c+101; j++){
                dp[j]=Math.min(dp[j],cost+dp[j-people]);
            }
        }

        int result=Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++){
            result=Math.min(result,dp[i]);
        }
        System.out.println(result);

    }

}
