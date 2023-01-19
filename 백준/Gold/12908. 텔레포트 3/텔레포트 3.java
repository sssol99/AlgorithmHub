/*
<문제 분석>
수빈이는 x,y격자판 위에 살고 있다
처음 수빈이의 위치는 xs, ys이고, 집이 위치한 xe,ye로 이동하려고한다
1. 점프 1초 : (사방 탐색)
2. 텔레포트 2초 : 정해진 3쌍의 위치로 이동 가능
집에 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오

<입력>
xs, ys(수빈이의 위치)
xe, ye(집 위치)
텔포 xy -> zh

<출력>
수빈이가 집에 가는 가장 빠른 시간을 출력한다

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long min;
	static int xs;
	static int ys;
	static int xe;
	static int ye;
	static int[][] telpo;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		xs = Integer.parseInt(stk.nextToken()); // 시작x
		ys = Integer.parseInt(stk.nextToken()); // 시작y

		stk = new StringTokenizer(br.readLine());

		xe = Integer.parseInt(stk.nextToken()); // 끝x
		ye = Integer.parseInt(stk.nextToken()); // 끝y


		telpo = new int[3][4]; //텔레포트의 정보

		for(int i = 0 ; i < 3 ; i++){
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 4 ; j++){
				telpo[i][j] =  Integer.parseInt(stk.nextToken());
			}
		}
		min = Long.MAX_VALUE;

		DFS(0,0,xs,ys);
		System.out.println(min);

	}

	public static int dir(int x, int y, int I, int J){
		return Math.abs(x-I)+Math.abs(y-J);
	}

	public static void DFS(int lv, long sum, int beforeX ,int beforeY){

		if(lv==3){
			min = Long.min(min,sum+dir(beforeX,beforeY,xe,ye));
			return;
		}

			for(int i = 0 ; i < 3 ; i++){
				DFS(lv+1,sum+dir(beforeX,beforeY,telpo[i][0],telpo[i][1])+10,telpo[i][2],telpo[i][3]); // 이전 ~ 텔포시작
				DFS(lv+1,sum+dir(beforeX,beforeY,telpo[i][2],telpo[i][3])+10,telpo[i][0],telpo[i][1]);
				DFS(lv+1,sum,beforeX,beforeY); // 그냥 넘어가기
			}
	}
}
