package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class b14425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();

    static Set<String> set = new HashSet<>();
    static int total = 0;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for (int i=0;i<n;i++) {
            set.add(br.readLine());
        }

        for (int i=0;i<m;i++) {
            if(set.contains(br.readLine())) total++;
        }

        System.out.print(total);

    }


}
