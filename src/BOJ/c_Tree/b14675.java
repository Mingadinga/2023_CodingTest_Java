package BOJ.c_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class b14675 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> count = new HashMap<>();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n-1;i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            count.put(a, (count.getOrDefault(a, 0) + 1));
            count.put(b, (count.getOrDefault(b, 0) + 1));
        }

        int q = Integer.parseInt(br.readLine());
        for (int i=0;i<q;i++) {
            String[] s = br.readLine().split(" ");
            int t = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            if(t==2) System.out.println("yes");
            else {
                if (count.get(k) == 1) System.out.println("no");
                else System.out.println("yes");
            }
        }

    }

}
