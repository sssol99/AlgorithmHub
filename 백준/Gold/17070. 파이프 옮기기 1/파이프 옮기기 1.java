import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int res = 0;

	static boolean house[][];
	static boolean ck[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		N = Integer.parseInt(br.readLine());

		house = new boolean[N][N];

		for(int i = 0 ; i < N ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++){
				int now = Integer.parseInt(stk.nextToken());
				if(now==1) 	house[i][j] = true;

			}
		}


		DFS(0,1,1);

		System.out.println(res);

	}

	public static void DFS(int I, int J, int now){ //1 : 가로  / 2 : 세로 / 3 : 대각선

		if(I==N-1 & J==N-1){
			res++;
			return;
		}

		// ↘
		int nextJ = J+1;
		int nextI = I+1;

		if(nextJ < N & nextI < N){
			if(!house[nextI][nextJ] & !house[I][nextJ] & !house[nextI][J]){
				DFS(nextI,nextJ,3);
			}
		}

		// ->
		if(now!= 2){
			nextI = I;
			nextJ = J+1;

			if( nextJ < N ){
				if(!house[nextI][nextJ]){
					DFS(nextI,nextJ,1);
				}
			}
		}

		// ↓
		if(now!=1){
			nextI = I+1;
			nextJ = J;

			if( nextI < N ){
				if(!house[nextI][nextJ]){
					DFS(nextI,nextJ,2);
				}
			}
		}
	}
}
