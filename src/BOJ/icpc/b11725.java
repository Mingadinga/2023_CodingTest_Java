package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b11725 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        HashMap<Integer, ArrayList<Integer>> connections = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            ArrayList<Integer> value1 = connections.getOrDefault(n1, new ArrayList<>());
            value1.add(n2);
            connections.put(n1, value1);

            ArrayList<Integer> value2 = connections.getOrDefault(n2, new ArrayList<>());
            value2.add(n1);
            connections.put(n2, value2);
        }

        int[] parent = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Deque<Integer> queue = new ArrayDeque<>();

        queue.addLast(1); visited[1] = true;

        while (!queue.isEmpty()) {
            Integer root = queue.pollFirst();
            ArrayList<Integer> children = connections.get(root);
            for (int child : children) {
                if (visited[child]) continue;
                parent[child] = root;
                visited[child] = true;
                queue.addLast(child);
            }
        }

        for (int i=2;i<n+1;i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);

    }
}
