package BOJ.i_Graph_Traverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b2252 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        answer = new int[N+1];
        for (int i=0;i<M;i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            List<Integer> temp = map.getOrDefault(from, new ArrayList<>());
            temp.add(to);
            map.put(from, temp);
        }

        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) DFS(i, visited);
        }

        for(int i=N;i>0;i--) sb.append(answer[i]).append(" ");
        System.out.println(sb);
    }

    private static void DFS(Integer node, boolean[] visited) {

        visited[node] = true;
        List<Integer> adjacentList = map.get(node);
        if (adjacentList != null) {
            for (Integer adjacent : adjacentList) {
                if (!visited[adjacent]) {
                    DFS(adjacent, visited);
                }
            }
        }

        addAnswer(node);

    }

    static int[] answer;
    static int globalIndex = 1;
    static void addAnswer(Integer num) {
        answer[globalIndex++] = num;
    }
}
