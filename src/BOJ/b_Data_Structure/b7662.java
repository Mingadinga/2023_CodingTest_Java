package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class b7662 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++) {
            int k = Integer.parseInt(br.readLine());
            for(int j=0;j<k;j++) {
                String[] inputs = br.readLine().split(" ");
                String command = inputs[0];
                Integer option = Integer.parseInt(inputs[1]);
                execute(command, option);
            }
            printResult();
            sortedMap.clear();
        }
        System.out.print(sb);
    }

    private static void printResult() {
        if (sortedMap.isEmpty()) sb.append("EMPTY\n");
        else sb.append(String.format("%d %d\n", sortedMap.lastKey(), sortedMap.firstKey()));
    }

    private static void execute(String command, Integer option) {
        if (command.compareTo("I")==0) {
            sortedMap.put(option, sortedMap.getOrDefault(option, 0)+1);
        } else if (command.compareTo("D")==0) {
            if (sortedMap.isEmpty()) return;
            if (option == -1) {
                Map.Entry<Integer, Integer> firstEntry = sortedMap.firstEntry();
                if (firstEntry.getValue() == 1) sortedMap.remove(firstEntry.getKey());
                else sortedMap.put(firstEntry.getKey(), firstEntry.getValue()-1);
            } else if (option == 1) {
                Map.Entry<Integer, Integer> lastEntry = sortedMap.lastEntry();
                if (lastEntry.getValue() == 1) sortedMap.remove(lastEntry.getKey());
                else sortedMap.put(lastEntry.getKey(), lastEntry.getValue()-1);
            }
        }
    }
}
