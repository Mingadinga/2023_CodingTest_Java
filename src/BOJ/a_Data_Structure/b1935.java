package BOJ.a_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class b1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Double> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        String prefix_exp = br.readLine();

        HashMap<Character, Double> values = new HashMap<>();
        for (int i=0;i<n;i++) {
            values.put((char) ('A' + i), Double.valueOf(br.readLine()));
        }

        double result = 0;
        for (int i=0;i<prefix_exp.length();i++) {
            char token = prefix_exp.charAt(i);
            if (token >= 'A' && token <= 'Z') {
                stack.addLast(values.get(token));
            } else {
                Double second = stack.removeLast();
                Double first = stack.removeLast();

                switch (token) {
                    case ('+'):
                        result = first + second;
                        break;
                    case ('-'):
                        result = first - second;
                        break;
                    case ('*'):
                        result = first * second;
                        break;
                    case ('/'):
                        result = first / second;
                        break;
                }
                stack.addLast(result);
            }
        }

        System.out.printf("%.2f", (double) result);
    }
}
