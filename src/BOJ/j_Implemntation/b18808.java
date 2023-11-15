package BOJ.j_Implemntation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b18808 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // 스케치북 입력
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        boolean[][] sketchBook = new boolean[n][m];

        // 스티커 입력
        int k = Integer.parseInt(input[2]);
        List<Sticker> stickerList = inputStickerList(k);

        // 스티커 붙이기
        putStickers(stickerList, sketchBook);

        // 스케치북에 붙은 스티커 개수 세기
        System.out.println(checkCountThatStickerAttached(sketchBook));

    }

    private static List<Sticker> inputStickerList(int stickerCount) throws IOException {
        List<Sticker> stickerList = new ArrayList<>();
        // 스티커 입력
        for (int i = 0; i< stickerCount; i++) {
            String[] rc = br.readLine().split(" ");

            // 스티커 크기 입력
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);

            // 스티커 내용 입력
            boolean[][] arr = new boolean[r][c];
            for (int j=0;j<r;j++) {
                String[] attached = br.readLine().split(" ");
                for (int l=0;l<c;l++) {
                    arr[j][l] = attached[l].contentEquals("1");
                }
            }

            stickerList.add(new Sticker(r, c, arr));
        }
        return stickerList;
    }

    private static int checkCountThatStickerAttached(boolean[][] sketchBook) {
        int count = 0;
        int r = sketchBook.length;
        int c = sketchBook[0].length;
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                if (sketchBook[i][j]) count++;
            }
        }

        return count;
    }

    private static void putStickers(List<Sticker> stickerList, boolean[][] sketchBook) {
        int r = sketchBook.length;
        int c = sketchBook[0].length;

        // 각 스티커 붙이기 시도
        for (Sticker sticker: stickerList) {
            boolean putSuccess = false;
            // 해당 스티커 붙이기에 성공하기까지 90도씩 회전
            for (int rotate = 0; rotate < 4 && !putSuccess; rotate++) {
                if (rotate > 0) sticker = sticker.rotate();
                // 붙이기 시도
                for (int i = 0; i < r && !putSuccess; i++) {
                    for (int j = 0; j < c; j++) {
                        if (sticker.isAbleToPutAt(sketchBook, i, j)) {
                            sticker.putAt(sketchBook, i, j);
                            putSuccess = true;
                            break;
                        }
                    }
                }
            }

        }
    }

    static class Sticker {
        int r, c;
        boolean[][] arr;

        public Sticker(int r, int c, boolean[][] arr) {
            this.r = r;
            this.c = c;
            this.arr = arr;
        }

        public boolean isAbleToPutAt(boolean[][] sketchBook, int startI, int startJ) {
            for (int i=0;i<r;i++) {
                for (int j=0;j<c;j++) {
                    if (startI+i >= sketchBook.length) return false;
                    if (startJ+j >= sketchBook[0].length) return false;
                    if (arr[i][j] && sketchBook[startI+i][startJ+j]) {
                        return false;
                    }
                }
            }

            return true;
        }

        public void putAt(boolean[][] sketchBook, int startI, int startJ) {
            for (int i=0;i<r;i++) {
                for (int j=0;j<c;j++) {
                    if (!sketchBook[startI+i][startJ+j]) {
                        sketchBook[startI+i][startJ+j] = arr[i][j];
                    }
                }
            }
        }

        public Sticker rotate() {
            boolean[][] newArr = new boolean[this.c][this.r];

            for (int i=0;i<this.c;i++) {
                for (int j=0;j<this.r;j++) {
                    newArr[i][j] = this.arr[r-1-j][i];
                }
            }

            return new Sticker(this.c, this.r, newArr);
        }

    }

}
