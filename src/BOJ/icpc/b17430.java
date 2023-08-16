package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class b17430 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Coordinate> lights = new ArrayList<>();
    static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

    private static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Coordinate) {
                Coordinate comp = (Coordinate) obj;
                if (comp.x == this.x && comp.y == this.y) return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            for (int j=0;j<N;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                ArrayList<Integer> value = map.getOrDefault(x, new ArrayList<Integer>());
                value.add(y);
                map.put(x, value);
            }
            if (isBalanced(map)) sb.append("BALANCED\n");
            else sb.append("NOT BALANCED\n");
        }
        System.out.print(sb);
    }

    private static boolean isBalanced(TreeMap<Integer, ArrayList<Integer>> map) {
        Iterator<ArrayList<Integer>> values = map.values().iterator();

        ArrayList<Integer> cur = values.next();
        List<Integer> sortedCur = cur.stream().sorted().collect(Collectors.toList());

        while (values.hasNext()) {
            ArrayList<Integer> next = values.next();
            List<Integer> sortedNext = next.stream().sorted().collect(Collectors.toList());

            if (sortedCur.size() != sortedNext.size()) return false;
            for (int i=0;i<sortedCur.size();i++) {
                if (sortedCur.get(i) != sortedNext.get(i)) return false;
            }

            sortedCur = sortedNext;
        }
        return true;
    }

}
