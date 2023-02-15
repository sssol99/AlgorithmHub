
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;

			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int[][] dp = new int[N][N];


			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			if(arr[0][0] == 0)  dp[0][0] = 1;

			for(int i = 1 ; i < N ; i++){
				 dp[i][0] = dp[i-1][0]+calc(dp[i-1][0]%3,arr[i][0]);
				 dp[0][i] = dp[0][i-1]+calc(dp[0][i-1]%3,arr[0][i]);
			}

			for(int i = 1 ; i < N ; i++){
				for(int j = 1 ; j < N ; j ++){
					dp[i][j] = Integer.max(dp[i-1][j] + calc(arr[i][j],dp[i-1][j]%3),dp[i][j-1]+calc(arr[i][j],dp[i][j-1]%3));
				}
			}
			System.out.println(dp[N-1][N-1]);
		}

		public static int calc(int prev, int cur){
			if(prev == cur) return 1;
			return 0;
		}
}