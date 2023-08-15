package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class b4358 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static TreeMap<String, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        int totalTreeCount = 0;

        while(true) {
            String tree = br.readLine();
            if (tree == null || tree.length() == 0) break;

            totalTreeCount++;
            treeMap.put(tree, treeMap.getOrDefault(tree, 0) + 1);
        }

        for (Map.Entry<String, Integer> t : treeMap.entrySet()) {
            sb.append(t.getKey())
                    .append(" ")
                    .append(String.format("%.4f", (t.getValue() * 1.0 / totalTreeCount) * 100.0))
                    .append("\n");
        }

        System.out.print(sb);

    }
}
