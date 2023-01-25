
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static final int DIVIDE = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TK = Integer.parseInt(br.readLine());

		int arr[] = new int[TK]; //N저장
		int max = 0;

		for(int t = 0 ; t < TK ; t++){
			arr[t] = Integer.parseInt(br.readLine());
			max = Integer.max(max,arr[t]);
		}

		long[][] dp = new long[max+1][7]; //칼날의 개수, 모양순서

		for(int i = 0 ; i < 7 ; i++){
			dp[1][i] = 1;
		}

		for(int m = 2; m <= max ; m++){

			for(int i = 0 ; i < 7 ; i++){
				dp[m][0]+=dp[m-1][i];
				dp[m][0]%=DIVIDE;
			}

			dp[m][3] = dp[m][0];
			dp[m][4] = dp[m][0];

			dp[m][1] = (((dp[m-1][0] + dp[m-1][5])%DIVIDE) + dp[m-1][6])%DIVIDE;
			dp[m][2] = dp[m][1];
			dp[m][5] = dp[m][1];
			dp[m][6] = dp[m][1];
		}

		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i < TK ; i++){
			long sum = 0;
			for(int j = 0 ; j  <7 ; j++){
				sum+=dp[arr[i]][j];
				sum%=DIVIDE;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
