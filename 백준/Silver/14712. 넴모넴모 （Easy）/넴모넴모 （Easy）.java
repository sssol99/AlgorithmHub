
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	<문제 조건>
	 세로 : M
	 가로 : N
 *N과 M은 1이상 25 이하
 *격자판 위에서 넴모가 나오지 않는 모든 경우의 수를 출력한다

	<넴모>
	2*2 사각형을 이루는 배치

	<힌트>
	2*2격자판에 넴모를 배치하는 방법은 모든 배치 경우의 수 - 네 칸 모두에 넴모가 올라가 있는 경우

	<풀이 방법>
	 왼쪽, 왼쪽 대각선, 위쪽을 체크해서 넴모인지 확인
 */
public class Main {

	static int res; // 답 저장할 배열
	static int I; //열
	static int J; //행
	static int DI[] = {0,-1,-1}; // 넴모체크 I
	static int DJ[] = {-1,-1,0}; // 넴모체크 J
	static boolean[][] arr;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		I = Integer.parseInt(stk.nextToken()); // 행
		J = Integer.parseInt(stk.nextToken()); // 열	

		arr = new boolean[I+1][J+1]; // 배열 초기화

		DFS(0);
		System.out.println(res);
	}

	public static void DFS(int cnt) {
		if(cnt==I*J){
			res++;
			return;
		}

		int nextI = cnt/J+1;
		int nextJ = cnt%J+1;

		//넴모일 때
		if(arr[nextI][nextJ-1] == true && arr[nextI-1][nextJ] == true  && arr[nextI-1][nextJ-1] == true ){
			arr[nextI][nextJ] = false;
			DFS(cnt+1);
		}else{
			arr[nextI][nextJ] = false;
			DFS(cnt+1);
			arr[nextI][nextJ] = true;
			DFS(cnt+1);
		}
	}
}
