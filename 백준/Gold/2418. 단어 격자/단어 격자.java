import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int H;
	static int W;
	static int L;

	static int[] dI = {-1,-1,0,1,1,1,0,-1};
	static int[] dJ = {0,1,1,1,0,-1,-1,-1};

	static char[] lWord;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		H = Integer.parseInt(stk.nextToken());
		W = Integer.parseInt(stk.nextToken());
		L = Integer.parseInt(stk.nextToken()); // 단어의 길이

		char[][] words = new char[H][W];
		long[][][] dp = new long[L][H][W];

		for (int i = 0; i < H; i++) {
			String now = br.readLine();
			for (int j = 0; j < W; j++) {
				words[i][j] = now.charAt(j);
			}
		}

		lWord = new char[L];
		String now = br.readLine();

		for (int i = 0; i < L; i++) {
			lWord[i] = now.charAt(i);
		}


		//첫번째 단어는 미리 넣기
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(words[i][j] == lWord[0]){
						dp[0][i][j] = 1;
					}
				}
			}

		// dp 테이블 돌면서 해당 레벨에 속하는 단어가 있으면 주변 체크
		for (int l = 1; l < L; l++) {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					//현재 레벨과 일치하는 단어가 있으면
					if(lWord[l] == words[i][j]){
						for(int d = 0 ; d < 8 ; d++){
							int nextI = i+dI[d];
							int nextJ = j+dJ[d];
							if(nextI < 0 | nextI >= H | nextJ < 0 | nextJ >= W) continue;

							if(words[nextI][nextJ] == lWord[l-1]){
								dp[l][i][j] += dp[l-1][nextI][nextJ];
							}
						}
					}
				}
			}
		}

		long res = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
					res+= dp[L-1][i][j];
				}
			}

		System.out.println(res);

	}
}
