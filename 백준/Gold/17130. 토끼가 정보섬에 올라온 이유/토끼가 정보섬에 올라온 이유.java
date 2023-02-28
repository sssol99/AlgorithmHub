import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static char island[][];
	static int dp[][];
	static int I;
	static int J;

	static int[] dI = {-1,0,1};
	static int[] dJ = {1,1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		I = Integer.parseInt(stk.nextToken());
		J = Integer.parseInt(stk.nextToken());

		int rabbitI = 0;
		int rabbitJ = 0;

		island = new char[I][J];
		dp = new int[I][J];

		for(int i = 0 ; i < I ; i++){
			String tmp = br.readLine();
			for(int j = 0 ; j < J ; j++){
				island[i][j] = tmp.charAt(j);
				if(island[i][j] == 'R'){
					rabbitI = i;
					rabbitJ = j;
				}
			}
		}

		for(int i = 0 ; i < I ; i++) {
			for (int j = 0; j < J; j++) {
				dp[i][j] = -1;
			}
		}
			DFS(rabbitI,rabbitJ,new boolean[I][J]);
			System.out.println(dp[rabbitI][rabbitJ]);

	}


	public static int DFS(int nowI, int nowJ, boolean visit[][]){
		if(visit[nowI][nowJ]) return dp[nowI][nowJ];
		if(island[nowI][nowJ] == 'O') dp[nowI][nowJ] = 0;

		for(int d = 0 ; d < 3 ; d++){
			int nextI = nowI+dI[d];
			int nextJ = nowJ+dJ[d];
			if(nextI < 0 | nextI >= I | nextJ < 0 | nextJ >=J) continue;

			if(island[nextI][nextJ] == '#') continue;

			dp[nowI][nowJ] = Integer.max(dp[nowI][nowJ], DFS(nextI,nextJ,visit));

		}
		if(dp[nowI][nowJ] != -1 & island[nowI][nowJ] == 'C') dp[nowI][nowJ]+=1;

		visit[nowI][nowJ] = true;

		return dp[nowI][nowJ];
	}
}
