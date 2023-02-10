
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] dirI = {0,-1,0,1}; //→↑←↓
	static int[] dirJ = {1,0,-1,0};
	static int[] cuvDir = {1,2,3,0};

	static boolean[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		arr = new boolean[101][101];

		int N = Integer.parseInt(br.readLine()); // 드래곤 커브의 수

		for(int n = 0 ; n < N ; n++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int J = Integer.parseInt(stk.nextToken());
			int I = Integer.parseInt(stk.nextToken());
			int D = Integer.parseInt(stk.nextToken()); // 시작 방향
			int g = Integer.parseInt(stk.nextToken()); // 세대

			makeDragonCurv(I,J,D,g);
		}
		System.out.println(checkNemo());

	}

	//네모 개수 확인하는 메소드
	private static int checkNemo() {
		int res = 0;
		for(int i = 0 ; i < 100 ; i++){
			for(int j = 0 ; j < 100 ; j++){
				if(arr[i][j] & arr[i+1][j] & arr[i+1][j+1] & arr[i][j+1]) res++;
			}
		}
		return res;
	}

	//드래곤 커브를 arr에 찍는 메소드
	private static void makeDragonCurv(int I, int J, int D, int g) {

		//0세대
		arr[I][J] = true;
		I = I + dirI[D];
		J = J + dirJ[D];
		arr[I][J] = true;

		ArrayList<Integer> dragonCurve = new ArrayList<>();
		dragonCurve.add(D);

		//1세대~
		for(int i = 0 ; i < g ; i++){
			for(int j = dragonCurve.size()-1 ; j >=0  ; j--){
				int dir = cuvDir[dragonCurve.get(j)];
				dragonCurve.add(dir);
				I = I + dirI[dir];
				J = J + dirJ[dir];
				arr[I][J] = true;
			}
		}
	}
}