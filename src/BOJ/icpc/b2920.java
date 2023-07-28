package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2920 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] s = br.readLine().split(" ");
        int[] notes = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();

        if(isAscending(notes)) System.out.println("ascending");
        else if(isDescending(notes)) System.out.println("descending");
        else System.out.println("mixed");
    }

    private static boolean isAscending(int[] note) {
        if (note[0] != 1) return false;
        for (int i=1;i<8;i++) {
            if (note[i] != note[i-1]+1) return false;
        }
        return true;
    }

    private static boolean isDescending(int[] note) {
        if (note[0] != 8) return false;
        for (int i=1;i<8;i++) {
            if (note[i] != note[i-1]-1) return false;
        }
        return true;
    }

}
