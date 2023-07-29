package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2750 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for(int i=0;i<n;i++) {
            numbers[i]=(Integer.parseInt(br.readLine()));
        }
        Arrays.sort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);
    }
}
