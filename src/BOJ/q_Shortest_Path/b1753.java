package BOJ.q_Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class b1753 {

    static int V, E, K;
    static final int INF = Integer.MAX_VALUE;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, List<Edge>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        String[] ve = br.readLine().split(" ");
        V = Integer.parseInt(ve[0]);
        E = Integer.parseInt(ve[1]);
        K = Integer.parseInt(br.readLine());

        for (int i=0;i<E;i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Edge> list = map.getOrDefault(edge[0], new ArrayList<>());
            list.add(new Edge(edge[1], edge[2]));
            map.put(edge[0], list);
        }

        printAnswer(dikstra());

    }

    private static void printAnswer(int[] answerArray) {
        for (int i = 1;i < answerArray.length; i++) {
            if (i == K) {
                System.out.println(0);
            }
            else if (answerArray[i] >= INF) {
                System.out.println("INF");
            } else {
                System.out.println(answerArray[i]);
            }
        }
    }

    private static int[] dikstra() {
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        dist[K] = 0;
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        queue.add(new Edge(K, 0));

        // 반복
        while (!queue.isEmpty()) {
            Edge base = queue.poll();
            if (visited[base.toNum]) continue;
            visited[base.toNum] = true;

            List<Edge> adjacentEdges = map.get(base.toNum);
            if (adjacentEdges == null) continue;

            for (Edge adjacentEdge : adjacentEdges) {
                if (visited[adjacentEdge.toNum]) continue;
                int shortestDist = Math.min(dist[adjacentEdge.toNum], base.value + adjacentEdge.value);
                dist[adjacentEdge.toNum] = shortestDist;
                queue.offer(new Edge(adjacentEdge.toNum, shortestDist));
            }

        }

        return dist;

    }

    static class Edge implements Comparable<Edge> {
        int toNum, value;

        public Edge(int toNum, int value) {
            this.toNum = toNum;
            this.value = value;
        }


        @Override
        public int compareTo(Edge o) {
            return value - o.value;
        }
    }
}
