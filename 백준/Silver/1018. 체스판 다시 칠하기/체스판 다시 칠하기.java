import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dI = {-1,0,1,0};
	static int[] dJ = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int I = Integer.parseInt(stk.nextToken());
		int J = Integer.parseInt(stk.nextToken());

		boolean board[][] = new boolean[I][J];   // 보드 입력받을 배열

		for(int i = 0 ; i < I ; i ++){
			String str = br.readLine();
			for(int j = 0 ; j < J ; j++){
				if(str.charAt(j)== 'W') board[i][j] = true;
				else board[i][j] = false;
			}
		}

		int minRes = Integer.MAX_VALUE;

		for(int i = 0 ; i <= I-8 ; i++){
			for(int j = 0 ; j <= J-8 ; j++) {
				//시작이 하얀색인 경우
				minRes = Integer.min(minRes,findChangeNum(i,j,board, true));
				//시작이 까만색인 경우
				minRes = Integer.min(minRes,findChangeNum(i,j,board, false));
			}
		}

		System.out.println(minRes);
	}

	//black - false / white - true
	public static int findChangeNum(int I, int J, boolean[][] board, boolean state){
		int sum = 0;
		boolean nowState;
		for(int i = I ; i < I+8 ; i++){
			if(i%2==0) nowState = state;
			else nowState = !state;
			for(int j = J ; j < J+8 ; j++){
				if(nowState != board[i][j]) sum++;
				nowState = !nowState;
			}
		}
		return sum;
	}
}
