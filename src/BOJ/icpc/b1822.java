package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class b1822 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static TreeSet<Integer> aSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {

        String[] ab = br.readLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<a;i++) {
            aSet.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0;i<b;i++) {
            int bNum = Integer.parseInt(st.nextToken());
            aSet.remove(bNum);
        }

        int size = aSet.size();
        sb.append(size).append("\n");
        aSet.forEach(n -> sb.append(n).append(" "));

        System.out.print(sb);
    }
}
