package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s21974 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		final int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			int board[][] = new int[9][9];
			for (int i=0;i<9;i++) {
				String[] arr = br.readLine().split(" ");
				for (int j=0;j<9;j++) {
					board[i][j] = Integer.parseInt(arr[j]); 
				}
			}
			int result = isSudoku(board) ? 1 : 0;
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
			
		}

		System.out.print(sb);
	}

	private static boolean isSudoku(int[][] board) {
		
		boolean result = true;
		
		// 가로
		for (int i=0;i<9 && result;i++) {
			boolean[] slots = new boolean[10];
			for (int j=0;j<9;j++) {
				int curNum = board[i][j];
				if (slots[curNum]) {result = false; break;}
				else slots[curNum] = true;
			}
		}
		
		// 세로
		for (int j=0;j<9 && result;j++) {
			boolean[] slots = new boolean[10];
			for (int i=0;i<9;i++) {
				int curNum = board[i][j];
				if (slots[curNum]) {result = false; break;}
				else slots[curNum] = true;
			}
		}
		
		// 블록
		for (int bi=0;bi<3 && result;bi++) {
			for (int bj=0;bj<3 && result;bj++) {
				boolean[] slots = new boolean[10];
				for (int i=bi*3;i<(bi*3)+3 && result;i++) {
					for (int j=bj*3;j<(bj*3)+3;j++) {
						int curNum = board[i][j];
						if (slots[curNum]) {result = false; break;}
						else slots[curNum] = true;
					}
				}
			}
		}
		
		return result;
		
	}

}
