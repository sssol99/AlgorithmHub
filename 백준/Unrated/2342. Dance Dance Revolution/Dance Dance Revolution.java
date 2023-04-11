
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) throws Exception {
		int cal[][] = {{0,2,2,2,2},{2,1,3,4,3},{2,3,1,3,4},{2,4,3,1,3},{2,3,4,3,1}};
		ArrayList<Integer> arr= new ArrayList<>();

		while(true){
			int now = read();
			arr.add(now);
			if(now == 0) break;

		}


		int dp[][][] = new int[Integer.max(2,arr.size()+1)][5][5]; // dp 배열

		//dp 배열 초기화
		for(int i = 0 ; i < arr.size() ; i++){
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					dp[i][j][k] = 90000000;
				}
			}
		}

		dp[0][0][0] = 0;

		for (int i = 0; i < arr.size()-1; i++) {
			int now = arr.get(i);
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					if(dp[i][j][k] == 90000000) continue;
					dp[i+1][j][now] = Integer.min(dp[i][j][k] + cal[k][now], dp[i+1][j][now]);
					dp[i+1][now][k] = Integer.min(dp[i][j][k] + cal[j][now], dp[i+1][now][k]);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				min = Integer.min(dp[arr.size()-1][j][k],min);
			}
		}

		System.out.println(min);
	}


	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}

