package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b26258 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] xArray = new long[N];
        long[] pArray = new long[N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            xArray[i] = Integer.parseInt(s[0]);
            pArray[i] = Integer.parseInt(s[1]);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            float k = Float.parseFloat(br.readLine());
            int rangeOfFx = findRangeOfFx(k, xArray);
            sb.append(getLean(pArray[rangeOfFx], pArray[rangeOfFx+1])).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }

    static int getLean(long p1, long p2) {
        if (p1 < p2) return 1;
        else if (p1 == p2) return 0;
        else return -1;
    }

    static int findRangeOfFx(float k, long[] xArray) {
        int start = 0, end = xArray.length, mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (xArray[mid] <= k && k < xArray[mid + 1]) break;
            else if (k > xArray[mid]) start = mid + 1;
            else end = mid - 1;
        }

        return mid;
    }
}

//   static int findLeanOfFx(float k, List<Fx> fxList) {
//
//        int start = 0, end = fxList.size(), mid = (start + end) / 2;
//        Fx found = fxList.get(mid);
//
//        while (start <= end) {
//            mid = (start + end) / 2;
//            Fx temp = fxList.get(mid);
//            int isPointInRange = temp.isPointInRange(k);
//            if (isPointInRange == 0) { found = temp; break; }
//            else if (isPointInRange < 0) end = mid - 1;
//            else start = mid + 1;
//        }
//
//        return found.lean;
//    }
//
//    static class Fx {
//
//        int start;
//        int end;
//        int lean;
//        int point;
//
//        public Fx(int start, int curPoint) {
//            this.start = start;
//            this.end = start;
//            this.point = curPoint;
//        }
//
//        public int isPointInRange(float f) {
//            if (start <= f && f < end) return 0;
//            else if (end <= f) return 1; // 크다
//            else return -1; // 작다
//        }
//
//        public void update(int end, int afterPoint) {
//            this.end = end;
//            this.lean = calculateLean(this.point, afterPoint);
//        }
//
//        private int calculateLean(int curPoint, int afterPoint) {
//            if (curPoint > afterPoint) return -1;
//            else if (curPoint < afterPoint) return 1;
//            else return 0;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("start : %d  end : %d  lean : %d  point : %d\n", start, end, lean, point);
//        }
//    }

