
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken()); // 동전 종류
		int K = Integer.parseInt(stk.nextToken()); // 도달해야 할 값
		int[] coin = new int[N];
		int[][] dp = new int[K+1][N];
		int newN = 0;

		Arrays.fill(coin,Integer.MAX_VALUE);

		for(int n = 0 ; n < N ; n++){
			int tmpCoin = Integer.parseInt(br.readLine());
			if(tmpCoin > K) continue;
			newN++;
			coin[n] = tmpCoin;
		}

		Arrays.sort(coin);
		N = newN;

		// 가장 작은 coin 한 종류만 자리할 수 있는 곳을 초기화
		for(int i = 0 ; i < N ; i ++){
			dp[coin[i]][i] = 1;
		}

		//dp 시작!
		for(int i = 1 ; i < K+1 ; i++){
			for(int j = 0 ; j < N ; j++){
				if(i-coin[j] <= 0) continue;

				for(int k = 0 ; k <= j ; k++){
					dp[i][j] += dp[i-coin[j]][k];
				}
			}
		}

		int sum = 0;

		for (int i = 0 ; i< N ; i++){
			sum+=dp[K][i];
		}
		//정답 출력
		System.out.println(sum);
	}
}
