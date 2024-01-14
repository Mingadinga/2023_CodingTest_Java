package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s212712 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		final int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			// input variable
			String[] nm = br.readLine().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);
			
			// input board
			int[][] board = new int[N][N];
			for (int i=0;i<N;i++) {
				String[] intarr = br.readLine().split(" ");
				for (int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(intarr[j]); 
				}
			}
			
			int result = getMaxCount(board, M);
			sb.append("#").append(t+1).append(" ").append(result).append("\n");
			
		}
		
		System.out.print(sb);
		

	}

	private static int getMaxCount(int[][] board, int force) {
		
		return Math.max(checkVerticalEveryPoint(board, force), checkCrossEveryPoint(board, force));
	}
	
	private static int checkEveryPoint(int[][] board, int force, int[] di, int[] dj) {
		int N = board[0].length;
		int max = 0;
		
        // 각 좌표에 대해 체크 
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				int sum = 0;
				
				// 각 방향에 대해 체크 
				for (int d=0;d<4;d++) {
					for (int f=1;f<force;f++) {
						int ci = i + f * di[d];
						int cj = j + f * dj[d];
						if (ci < 0 || ci >= N) break;
						if (cj < 0 || cj >= N) break;
						sum += board[ci][cj];
					}
				}
				sum += board[i][j];
				max = Math.max(max, sum);
			}
		}
		
		return max;
	}
	
	private static int checkVerticalEveryPoint(int[][] board, int force) {
		int[] di = { -1, 1, 0, 0 };
        int[] dj = { 0, 0, 1, -1 };
		return checkEveryPoint(board, force, di, dj);
	}


	private static int checkCrossEveryPoint(int[][] board, int force) {
		int[] di = { -1, 1, -1, 1 };
        int[] dj = { -1, 1, 1, -1 };
        return checkEveryPoint(board, force, di, dj);
	}
	
}
