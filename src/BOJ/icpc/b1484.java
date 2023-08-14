package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b1484 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());

        long powerOf[] = new long[50001];

        for (int i=1;i<=50000;i++) {
            powerOf[i] = i * i;
        }

        int start = 1, end = 2;
        List<Integer> result = new ArrayList<>();
        while (end <= 50000) {
            long weight = (int) (powerOf[end] - powerOf[start]);
            if (weight == G) {
                result.add(end);
                end++;
            }
            else if (weight < G) {
                end++;
            } else {
                start++;
            }
        }

        Collections.sort(result);
        if(result.isEmpty() || G == 1) {
            sb.append(-1);
        }
        else {
            result.forEach(r -> sb.append(r).append("\n"));
        }

        System.out.print(sb);
    }
}
