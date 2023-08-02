package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b6131 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        List<Integer> squares = new ArrayList<>();

        for (int num=1;num<=500;num++) {
            squares.add(num * num);
        }

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i=0;i<squares.size();i++) {
            for (int j=0;j<squares.size();j++) {
                if (squares.get(j)-squares.get(i) == n) count++;
            }
        }
        System.out.println(count);
    }
}
