import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	static boolean[][] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new boolean[N+1][N+1];

		for(int j = 1 ; j < N ; j++){
			int loadCnt =Integer.parseInt(br.readLine());

			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int i = 1 ; i <= loadCnt ; i++){
				int go  = Integer.parseInt(stk.nextToken());

				arr[j][go] = true;
			}
		}

		for(int k = 0 ; k < N+1 ; k++){
			for(int i = 0 ; i < N+1 ; i++){
				for(int j = 0 ; j < N+1 ; j++){
					if(arr[i][k] & arr[k][j]) arr[i][j] = true;
				}
			}
		}

		for(int i = 1 ; i < N+1 ; i++){
				if(arr[1][i] & arr[i][i]) {
					System.out.println("CYCLE");
					System.exit(0);
				}

		}
		System.out.println("NO CYCLE");
	}
}
