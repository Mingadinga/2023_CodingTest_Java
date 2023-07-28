package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2566 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int i = 0, max_i = 1, max_j = 1;
        int max = -1;

        while(true) {
            String input = br.readLine();
            if(input == null || input.compareTo("") == 0) break;

            String[] tokens = input.split(" ");
            for (int j=0;j<tokens.length;j++) {
                if (max < Integer.parseInt(tokens[j])) {
                    max = Integer.parseInt(tokens[j]);
                    max_i = i + 1;
                    max_j = j + 1;
                }
            }

            i++;
        }

        System.out.printf("%d\n%d %d\n", max, max_i, max_j);
    }
}
