import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		int I = read();
		int J = read();

		int[][] arr = new int[I+1][J+1];
		int maxV = -20000*40000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= I; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 1; j <= J; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				maxV = Integer.max(arr[i][j],maxV);
			}
		}


		//1. 가로 직사각형 채우기
		int[][] dp = new int[I+1][J+1];
		for (int i = 1; i < I+1; i++) {
			for (int j = 1; j < J+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] + arr[i][j] - dp[i-1][j-1];
				maxV = Integer.max(dp[i][j],maxV);
			}
		}

//		for (int i = 1; i <= I; i++) {
//			for (int j = 1; j <= J; j++) {
//				System.out.print(dp[i][j]+" ");
//				}
//			System.out.println();
//			}

		for (int i = 1; i <= I; i++) {
			for (int j = 1; j <= J; j++) {
				for (int k = 1; k < i; k++) {
					for (int l = 1; l < j; l++) {
						int a = dp[i][j] - dp[i-k][j] - dp[i][j-l] + dp[i-k][j-l];
						maxV = Integer.max(a,maxV);
					}
				}

			}
		}
		System.out.println(maxV);
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}

