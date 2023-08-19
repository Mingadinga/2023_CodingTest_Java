package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1260 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, ArrayList<Integer>> connections = new HashMap<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int i=0;i<n;i++) connections.put(i+1, new ArrayList<>());

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> aList = connections.get(a);
            aList.add(b);

            ArrayList<Integer> bList = connections.get(b);
            bList.add(a);
        }

        for (int i=1;i<=n;i++) {
            ArrayList<Integer> list = connections.get(i);
            Collections.sort(list);
        }

        // dfs
        dfs(v, n, new boolean[n+1]);

        sb.append("\n");

        // bfs
        bfs(v, n);

        System.out.print(sb);
    }

    static void dfs(int nodeIndex, int nodeCount, boolean[] visited) {
        visited[nodeIndex] = true;
        sb.append(nodeIndex).append(" ");

        for (int node : connections.get(nodeIndex)) {
            if (visited[node]) continue;
            dfs(node, nodeCount, visited);
        }

    }


    static void bfs(int start, int nodeCount) {

        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[nodeCount+1];
        queue.addLast(start); visited[start] = true;

        while (!queue.isEmpty()) {
            Integer head = queue.pollFirst();

            sb.append(head).append(" ");

            for (int connect : connections.get(head)) {
                if (visited[connect]) continue;
                visited[connect] = true;
                queue.addLast(connect);
            }

        }

        sb.append("\n");

    }

}
