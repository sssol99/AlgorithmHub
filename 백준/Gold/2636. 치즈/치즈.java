import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int I;
	static int J;
	static int arr[][];

	static boolean ck[][];

	static int[] dI = {-1,0,1,0};
	static int[] dJ = {0,1,0,-1};

	static int cheeseCnt = 0;

	//0 -> 빈부분 //-1 -> 공기랑 닿는 빈공간 //  //1->그냥치즈 //2 -> 녹일치즈
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		I = Integer.parseInt(stk.nextToken());
		J = Integer.parseInt(stk.nextToken());
		arr = new int[I][J];

		for(int i = 0 ; i < I ; i++){
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < J ; j++){
				arr[i][j] = Integer.parseInt(stk.nextToken());
				if(arr[i][j] == 1) cheeseCnt++;
			}
		}



		int time = 0;
		int beforeCheese = 0;
		while(cheeseCnt>0){
			beforeCheese = cheeseCnt;
			findEmpty();
			findMeltCheese();
			time++;
		}

		System.out.println(time);
		System.out.println(beforeCheese);

	}



	//공기에 닿은 빈공간 찾기
	public static void findEmpty(){
		ck = new boolean[I][J];
		for(int i = 0 ; i <  I ; i++){

			if(arr[i][0]<=0) {
				arr[i][0] = -1;
				paint(i,0);
			}
			if(arr[i][J-1]<=0) {
				arr[i][J-1] = -1;
				paint(i,J-1);
			}
		}

		for(int j= 0 ; j < J ; j++){
			if(arr[0][j]<=0)  {
				arr[0][j] = -1;
				paint(0,j);
			}
			if(arr[I-1][j]<=0) {
				arr[I-1][j] = -1;
				paint(I-1,j);
			}
		}
	}

	//녹일치즈 찾아서 녹이기
	public static void findMeltCheese(){
		ck = new boolean[I][J];
		for(int i = 0 ; i <  I ; i++){
			for(int j = 0 ; j < J ; j++){
				if(arr[i][j]==-1) {
						for(int d = 0 ; d < 4 ; d++){
							int nextI = i+dI[d];
							int nextJ = j+dJ[d];

							if(nextI <0 | nextI >=I | nextJ <0 | nextJ >=J) continue;
							if(ck[nextI][nextJ]) continue;
							ck[nextI][nextJ] = true;

							if(arr[nextI][nextJ] ==1) arr[nextI][nextJ] = 2;
					}

				}
			}
		}

		for(int i = 0 ; i <  I ; i++){
			for(int j = 0 ; j < J ; j++){
				if(arr[i][j]==2) {
					arr[i][j] = -1;
					cheeseCnt--;
				}
			}
		}
	}

	public static void paint(int II, int JJ ){

		for(int d = 0 ; d < 4 ; d++){
			int nextI = II+dI[d];
			int nextJ = JJ+dJ[d];

			if(nextI <0 | nextI >=I | nextJ <0 | nextJ >=J) continue;
			if(ck[nextI][nextJ]) continue;
			ck[nextI][nextJ] = true;

			checkCheese(nextI,nextJ);

			if(arr[nextI][nextJ] <=0) paint(nextI,nextJ);
		}
	}
	
	public static void checkCheese(int nextI, int nextJ ){
		if(arr[nextI][nextJ] <= 0 ) arr[nextI][nextJ] = -1;
	}

}
