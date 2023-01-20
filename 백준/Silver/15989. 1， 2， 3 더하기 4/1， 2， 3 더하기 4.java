import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tk = Integer.parseInt(br.readLine());
		int arr[][] = new int[10001][3];

		//1~3까지 초기화
		for(int i = 1 ; i <= 3 ; i++){
			for(int j = 0 ; j < i ; j++){
				arr[i][j] = 1;
			}
		}

		//DP 시작
		for(int i = 4 ; i < 10001 ; i++){
			arr[i][0] = 1;
			arr[i][1] = arr[i-2][1] + arr[i-2][0];
			arr[i][2] = arr[i-3][0] + arr[i-3][1] + arr[i-3][2];
		}

		StringBuilder sb = new StringBuilder();

		for(int t = 0; t < tk ; t++){
			int N = Integer.parseInt(br.readLine());

			sb.append(arr[N][0]+arr[N][1]+arr[N][2]+"\n");
		}
		System.out.println(sb);
	}
}
