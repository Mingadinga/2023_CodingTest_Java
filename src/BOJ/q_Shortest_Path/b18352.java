package BOJ.q_Shortest_Path;

import java.util.*;
import java.io.*;

public class b18352 {

    private static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> list = new ArrayList<>();
    static int dist[];
    static int N, M, K, X;

    static class Node implements Comparable<Node> {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, INF);
        list = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        while(M-->0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(new Node(y, 1));
        }

        dijkstra(X);

        for(int i=1; i<dist.length; i++) {
            if(dist[i] == K) {
                sb.append(i).append('\n');
            }
        }

        if(sb.length() == 0) {
            System.out.println(-1);
        }
        else {
            System.out.println(sb);
        }

    }

    private static void dijkstra(int cityNum) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean visit[] = new boolean[N+1];
        dist[cityNum] = 0;

        que.offer(new Node(cityNum, 0));

        while( !que.isEmpty() ) {
            Node node = que.poll();
            int num = node.num;

            if(visit[num]) continue;
            visit[num] = true;

            for(Node c : list.get(num)) {
                if( !visit[c.num] ) {
                    dist[c.num] = Math.min(dist[c.num], c.weight + dist[num]);
                    que.offer(new Node(c.num, dist[c.num]));
                }
            }
        }

    }
}
