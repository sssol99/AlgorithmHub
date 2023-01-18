
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
<문제 분석>
로봇은 4방향 중에 하나를 임의로 선택하고, 그 방향으로 한 칸 이동한다
이동 경로가 단순함 : 같은 곳을 한 번만 이동할 때

<입력>
N, 각 방향의 확률(동,서,남,북)

<출력>
로봇의 이동 경로가 단순할 확률을 출력한다

 */
public class Main {

	static int N;
	static double dir[];

	static double res = 0.0;

	static boolean ck[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		dir = new double[4];
		ck= new boolean[100][100];

		for(int i = 0 ; i < 4 ; i++){
			int per = Integer.parseInt(stk.nextToken());
			dir[i] = per/100.0;
		}


		DFS(50,50,0,1);

		System.out.println(String.format("%.10f", 1-res));

	}
	public static void DFS(int I, int J, int lv, double per ) { //깊이, 이전 인덱스


		if(ck[I][J]) {
			res+=per;
			return;
		}

		if (lv == N) return;


		ck[I][J] = true;
		DFS(I,J+1,lv+1,per*dir[0]); //동
		DFS(I,J-1,lv+1,per*dir[1]); //서
		DFS(I+1,J,lv+1,per*dir[2]); //남
		DFS(I-1,J,lv+1,per*dir[3]); //북
		ck[I][J] = false;
	}
}
