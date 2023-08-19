package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b17616 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count = 0;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        HashMap<Integer, ArrayList<Integer>> connections = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> reversedConnections = new HashMap<>();

        for (int i=1;i<=n;i++) {
            connections.put(i, new ArrayList<>());
            reversedConnections.put(i, new ArrayList<>());
        }

        for (int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ArrayList<Integer> aList = connections.get(a);
            aList.add(b);

            ArrayList<Integer> bList = reversedConnections.get(b);
            bList.add(a);
        }

        dfs(connections, x, new boolean[n+1]);
        int behind = count;
        count = 0;
        dfs(reversedConnections, x, new boolean[n+1]);
        int front = count;

        System.out.printf("%d %d", front, n - behind + 1);

    }

    private static void dfs(HashMap<Integer, ArrayList<Integer>> connections, int nodeIndex, boolean[] visited) {

        visited[nodeIndex] = true;
        count++;

        for (int node : connections.get(nodeIndex)) {
            if (visited[node]) continue;
            dfs(connections, node, visited);
        }

    }


}
