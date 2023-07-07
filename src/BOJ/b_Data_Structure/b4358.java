package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b4358 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> dict = new HashMap<>();
    static int total_count = 0;

    public static void main(String[] args) throws IOException {

        while(true) {
            String tree = br.readLine();
            if (tree == null || tree.length() == 0) break;
            if (dict.containsKey(tree)) dict.put(tree, dict.get(tree)+1);
            else dict.put(tree, 1);
            total_count++;
        }

        Object[] keys = dict.keySet().toArray();
        Arrays.sort(keys);

        for(Object key : keys) {
            sb.append((String) key)
                    .append(" ")
                    .append(String.format("%.4f", 100.0 * (dict.get((String) key)*1.0) / total_count))
                    .append("\n");
        }

        System.out.print(sb);

    }

}
