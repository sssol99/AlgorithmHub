import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[][] city = new int[N][N];

		for(int i = 0 ; i < N ; i++ ){
			for(int j = 0 ; j < N ; j++){
				if(i==j) continue;
				if(city[i][j] ==0) city[i][j] = 100*1000001;
			}
		}

		for(int i = 0 ; i < M ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken())-1;
			int end = Integer.parseInt(stk.nextToken())-1;
			int cost = Integer.parseInt(stk.nextToken());

			if(city[start][end] > cost) city[start][end] = cost;
		}


		//거쳐가는 정점을 기준으로 최단거리 구함
		for(int k = 0 ; k < N ; k++ ){
			for(int i = 0 ; i < N ; i++){
				for(int j = 0 ; j < N ; j++){
					city[i][j] = Integer.min(city[i][j], city[i][k]+city[k][j]);
				}
			}
		}

		for(int i = 0 ; i < N ; i++ ){
			for(int j = 0 ; j < N ; j++){
				if(city[i][j] >= 100*1000001) System.out.print("0"+" ");
				else System.out.print(city[i][j]+" ");
			}
			System.out.println();
		}

	}
}
