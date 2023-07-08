package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b11725 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list[];
    static boolean visited[];
    static int parents[];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        parents = new int[N+1];

        for (int i=0;i<N+1;i++) list[i] = new ArrayList<>();

        for (int i=0;i<N-1;i++) {
            String[] relation = br.readLine().split(" ");
            Integer start = Integer.parseInt(relation[0]);
            Integer end = Integer.parseInt(relation[1]);
            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);
        for (int i=2; i<N+1; i++) sb.append(parents[i]).append("\n");
        System.out.print(sb);

    }

    private static void dfs(int nodeIndex) {
        visited[nodeIndex] = true;

        for(int neighbor : list[nodeIndex]) {
            if (!visited[neighbor]) {
                parents[neighbor] = nodeIndex;
                dfs(neighbor);
            }
        }

    }
}
