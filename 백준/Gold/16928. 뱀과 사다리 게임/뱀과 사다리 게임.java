import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int dp[] = new int[101]; // 주사위 굴리는 수

		int sadariNum = Integer.parseInt(stk.nextToken());
		int snakeNum = Integer.parseInt(stk.nextToken());

		int[][] sadari = new int[sadariNum][2]; // 사다리 저장할 배열
		int[][] snake = new int[snakeNum][2]; // 뱀 저장할 배열


		for(int i = 0 ; i < sadariNum ; i++){
			stk = new StringTokenizer(br.readLine());

			sadari[i][0] = Integer.parseInt(stk.nextToken());
			sadari[i][1] = Integer.parseInt(stk.nextToken());
		}

		for(int i = 0 ; i < snakeNum ; i++){
			stk = new StringTokenizer(br.readLine());

			snake[i][0] = Integer.parseInt(stk.nextToken());
			snake[i][1] = Integer.parseInt(stk.nextToken());
		}

		Arrays.sort(sadari, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return  o1[0] - o2[0];
			}
		});
		Arrays.sort(snake, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		Arrays.fill(dp,99_99999);

		boolean[] snakeICk = new boolean[snakeNum];

		dp[1] = 0;
		dp[0] = 0;
		for(int i = 2 ; i < 101 ; i++){

			boolean snakeFlag = false;
			int snakeIdx = 0;
			for(int j = 0 ; j < snakeNum ; j++){
				if(snake[j][0] == i){
					snakeFlag = true;
					snakeIdx = j;
				}
			}

			boolean sadariFlag = false;
			int sadariIdx = 0;
			for(int j = 0 ; j < sadariNum ; j++){
				if(sadari[j][0] == i) {
					sadariFlag = true;
					sadariIdx = j;
				}
			}

			//사다리도 아니고, 뱀도 아닌 경우에
			if(!sadariFlag & !snakeFlag){
				for(int j = i ; j >= i-6 ; j--){
					if(j < 1 ) break;
					dp[i] = Integer.min(dp[j]+1,dp[i]);
				}
			}

			//처음 만난 뱀
			if(snakeFlag & !snakeICk[snakeIdx]){

				int min = Integer.MAX_VALUE;
				for(int j = i ; j >= i-6 ; j--){
					if(j < 1 ) break;
					min = Integer.min(dp[j]+1,min);
				}

				snakeICk[snakeIdx] = true;
				i = snake[snakeIdx][1];
				dp[i] = Integer.min(dp[i],min);
			}

			//처음 만난 사다리
			if(sadariFlag){

				int min = Integer.MAX_VALUE;
				for(int j = i ; j >= i-6 ; j--){
					if(j < 1 ) break;
					min = Integer.min(dp[j]+1,min);
				}

				dp[sadari[sadariIdx][1]] = Integer.min(min,dp[sadari[sadariIdx][1]]);
			}
		}
		System.out.println(dp[100]);
	}
}
