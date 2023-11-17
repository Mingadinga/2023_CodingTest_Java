package BOJ.i_Graph_Traverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class b1260 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static Map<Integer, List<Integer>> edges = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String[] nmv = br.readLine().split(" ");
        n = Integer.parseInt(nmv[0]);
        m = Integer.parseInt(nmv[1]);
        int v = Integer.parseInt(nmv[2]);

        for (int i=1;i<n+1;i++) {
            edges.put(i, new ArrayList<>());
        }

        for (int i=0;i<m;i++) {
            String[] strings = br.readLine().split(" ");
            int from = Integer.parseInt(strings[0]);
            int to = Integer.parseInt(strings[1]);
            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        for (int i=1;i<n+1;i++) {
            edges.get(i).sort(Comparator.comparingInt(l -> l));
        }

        System.out.println(dfs(v));
        System.out.println(bfs(v));

    }

    static StringBuilder sb = new StringBuilder();
    private static String dfs(int v) {
        dfs(v, new boolean[n+1]);
        return sb.toString();
    }

    private static void dfs(int v, boolean[] visited) {
        if (visited[v]) return;

        visited[v] = true;
        sb.append(v).append(" ");

        for (Integer adjacentNode: edges.get(v)) {
            if (!visited[adjacentNode]) {
                dfs(adjacentNode, visited);
            }
        }

    }

    private static String bfs(int v) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.add(v); visited[v] = true;
        sb.append(v).append(" ");

        while (!queue.isEmpty()) {
            Integer base = queue.poll();
            List<Integer> adjacentNodesOfBase = edges.get(base);
            for (Integer adjacentNode : adjacentNodesOfBase) {
                if (!visited[adjacentNode]) {
                    queue.add(adjacentNode); visited[adjacentNode] = true;
                    sb.append(adjacentNode).append(" ");
                }
            }
        }

        return sb.toString();
    }


}
