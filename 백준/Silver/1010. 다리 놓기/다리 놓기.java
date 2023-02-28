import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TK = Integer.parseInt(br.readLine());



		dp = new long[31][31];

		for(int i = 0 ; i <= 30 ; i++){
			dp[i][0] = 1;
			dp[i][i] = 1;
		}

		for(int i = 2 ; i < 30 ; i++){
			for(int j = 1 ; j < 30 ; j++){
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t < TK ; t++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());

			sb.append(dp[M][N]).append('\n');
		}

		System.out.println(sb);
	}

}
