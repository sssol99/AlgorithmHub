import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int I; // 세로
	static int J; // 가로

	static int arr[][];
	static int newarr[][];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		I = Integer.parseInt(stk.nextToken());
		J = Integer.parseInt(stk.nextToken());
		int IJmax = Integer.max(I,J);
		int R = Integer.parseInt(stk.nextToken()); //연산의 수
		arr = new int[IJmax][IJmax];
		newarr = new int[IJmax][IJmax];

		for(int i = 0 ; i < I ; i++){
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < J ; j++){
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		stk = new StringTokenizer(br.readLine());
		for(int r = 0 ; r < R ; r++){
			int nowOper = Integer.parseInt(stk.nextToken());

			switch (nowOper){
				case 1 :
					oper1();
					break;
				case 2 :
					oper2();
					break;
				case 3 :
					oper3();
					break;
				case 4 :
					oper4();
					break;
				case 5 :
					oper5();
					break;
				case 6 :
					oper6();
					break;
			}
		}

		for(int i = 0 ; i < I ; i++){
			for(int j = 0 ; j < J ; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	//1번 연산(상하반전)
	public static void oper1(){
		for(int i = 0 ; i < I ; i++){
			for(int j = 0 ; j < J ; j++){
				newarr[i][j] = arr[I-1-i][j];
			}
		}
		copy();

	}

	//2번 연산(좌우반전)
	public static void oper2(){
		for(int i = 0 ; i < I ; i++){
			for(int j = 0 ; j < J ; j++){
				newarr[i][j] = arr[i][J-1-j];
			}
		}
		copy();
	}

	//3번연산(오른쪽 90도회전)
	public static void oper3(){
		int tmp = I;
		I = J;
		J = tmp;
		for(int i = 0 ; i < I ; i++){
			for(int j = 0 ; j < J ; j++){
				newarr[i][j] = arr[J-1-j][i];
			}
		}
		copy();


	}

	//4번연산(왼쪽 90도 회전)
	public static void oper4(){
		int tmp = I;
		I = J;
		J = tmp;
		for(int i = 0 ; i < I ; i++){
			for(int j = 0 ; j < J ; j++){
				newarr[i][j] = arr[j][I-1-i];
			}
		}
		copy();
	}

	public static void oper5(){
		//4->1
		for(int i = 0 ; i < I/2 ; i++){
			for(int j = 0 ; j < J/2 ; j++){
				newarr[i][j] = arr[i+I/2][j];
			}
		}
		//1->2
		for(int i = 0 ; i < I/2 ; i++){
			for(int j = J/2 ; j < J ; j++){
				newarr[i][j] = arr[i][j-J/2];
			}
		}

		//2->3
		for(int i = I/2 ; i < I ; i++){
			for(int j = J/2 ; j < J ; j++){
				newarr[i][j] = arr[i-I/2][j];
			}
		}

		//3->4
		for(int i = I/2 ; i < I ; i++){
			for(int j = 0 ; j <  J/2 ; j++){
				newarr[i][j] = arr[i][j+J/2];
			}
		}
		copy();
	}

	public static void oper6(){
		//1 <- 4
		for(int i = 0 ; i < I/2 ; i++){
			for(int j = 0 ; j < J/2 ; j++){
				newarr[i+I/2][j] = arr[i][j];
			}
		}
		//1 <- 2
		for(int i = 0 ; i < I/2 ; i++){
			for(int j = J/2 ; j < J ; j++){
				newarr[i][j-J/2] = arr[i][j];
			}
		}

		//2<-3
		for(int i = I/2 ; i < I ; i++){
			for(int j = J/2 ; j < J ; j++){
				newarr[i-I/2][j] = arr[i][j];
			}
		}

		//3<-4
		for(int i = I/2 ; i < I ; i++){
			for(int j = 0 ; j <  J/2 ; j++){
				newarr[i][j+J/2] = arr[i][j];
			}
		}
		copy();
	}

	public static void copy(){
		for(int i = 0 ; i < I ; i++){
			for(int j = 0 ; j < J ; j ++){
				arr[i][j] = newarr[i][j];
			}
		}
	}
}
