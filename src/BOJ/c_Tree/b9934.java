package BOJ.c_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class b9934 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> floors = new ArrayList<>();

    static void checkVisitedBuildings(int[] buildings, int depth, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        floors.get(depth).add(buildings[mid]);
        checkVisitedBuildings(buildings, depth+1, start, mid);
        checkVisitedBuildings(buildings, depth+1, mid+1, end);
    }

    public static void main(String[] args) throws IOException {

        int k = Integer.parseInt(br.readLine());
        for(int i=0;i<k;i++) floors.add(new ArrayList<>());
        int[] visitedBuildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        checkVisitedBuildings(visitedBuildings, 0, 0, visitedBuildings.length);
        for(List<Integer> floor: floors) {
            sb.append(floor.stream().map(Object::toString).collect(Collectors.joining(" ")));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

}
