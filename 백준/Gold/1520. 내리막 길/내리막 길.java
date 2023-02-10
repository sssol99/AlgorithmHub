import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int MI;
	static int NJ;
	static int map[][];

	static int[][] dp;
	static int[] dI = {-1,0,1,0};
	static int[] dJ = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		 MI = Integer.parseInt(stk.nextToken());
		 NJ = Integer.parseInt(stk.nextToken());

		map = new int[MI][NJ];
		dp = new int[MI][NJ];


		for(int i = 0 ; i < MI ; i++){
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < NJ ; j++){
				map[i][j] = Integer.parseInt(stk.nextToken());
				dp[i][j] = -1;
			}
		}

		dp[MI-1][NJ-1] = 1;
		DFS(0,0);
		System.out.println(dp[0][0]);
	}

	private static int DFS(int I, int J) {

		if(dp[I][J] !=-1 ){
			return dp[I][J];
		}

		dp[I][J] = 0;
		for(int d = 0  ; d < 4 ; d++){
			int nextI = I + dI[d];
			int nextJ = J + dJ[d];

			if(nextI <0 | nextI >=MI | nextJ < 0 | nextJ >= NJ) continue;
			if(map[nextI][nextJ] >= map[I][J]) continue;

			dp[I][J] += DFS(nextI,nextJ);
		}

		return dp[I][J];
	}
}
