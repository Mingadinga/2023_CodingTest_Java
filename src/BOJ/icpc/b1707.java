package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1707 {

    final static int RED = 0;
    final static int BLUE = 1;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, List<Integer>> connections;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        int k = Integer.parseInt(br.readLine());
        for (int i=0;i<k;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            connections = new HashMap<>();
            for (int j=0;j<v;j++) {
                connections.put(j+1, new ArrayList<>());
            }

            for (int j=0;j<e;j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                List<Integer> aList = connections.get(a);
                aList.add(b);

                List<Integer> bList = connections.get(b);
                bList.add(a);
            }

            visited = new int[v+1]; // 1부터 유효
            for (int j=1;j<v+1;j++) {
                if (visited[j] == 0) bfs(j);
            }

            if (isBipartite()) System.out.println("YES");
            else System.out.println("NO");

        }


    }

    private static boolean isBipartite() {
        for (Map.Entry<Integer, List<Integer>> entry : connections.entrySet()) {
            int node = entry.getKey();
            List<Integer> adjacentNodes = entry.getValue();
            for (int adjacentNode : adjacentNodes) {
                if (visited[node] == visited[adjacentNode]) return false;
            }
        }
        return true;
    }

    private static int[] bfs(int startNode) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(startNode); visited[startNode] = RED;

        while (!queue.isEmpty()) {
            int curNode = queue.pollFirst();

            int nextColor = visited[curNode] == RED ? BLUE : RED;
            for (int nextNode : connections.get(curNode)) {
                if (visited[nextNode] != 0) continue;
                queue.addLast(nextNode);
                visited[nextNode] = nextColor;
            }

        }

        return visited;
    }
}
