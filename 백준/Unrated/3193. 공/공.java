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

		int N = Integer.parseInt(stk.nextToken()); // 게임판의 크기
		int K = Integer.parseInt(stk.nextToken()); // 회전 횟수
		char[][] arr = new char[N][N];
		int bI = 0; // 공의 위치 I
		int bJ = 0; // 공의 위치 J

		int cnt = 0; // 방향 개수 ( 시계 + 반시계 - )


		for(int i = 0 ; i < N ; i++){
			String tmp = br.readLine();
			for(int j = 0 ; j  <N ; j++){

				if(tmp.charAt(j) == 'L'){
					bI = i;
					bJ = j;
					arr[i][j] = '.';
					continue;
				}
				arr[i][j] = tmp.charAt(j);
			}
		}


		//실제로 회전시키지 않고, 어느 방향인지 찾음
		// 시계방향으로 한번 회전 : 반시계방향으로 dir 값 빼기 : 최초에 3로 시작
		// 반시계방향으로 한번 회전 : 시계방향으로 dir 값 추가 : 최초에 4로 시작

		int dir = 0;
		//최초에 이동할 값 넣기
		char DIR = br.readLine().charAt(0); // L or D
		if(DIR == 'L') {
			dir = 3; // 시계반대면 4(왼)로 시작
			cnt--;
		}
		else {
			dir = 1; // 시계방향이면 3(오른) 으로 시작
			cnt++;
		}

		int[] ballLoc = moveBall(N,arr,dir,bI,bJ); // 공 움직이기
		// 공 위치 갱신
		bI = ballLoc[0];
		bJ = ballLoc[1];

		for(int i = 1 ; i < K ; i++){
			DIR = br.readLine().charAt(0); // L or D
			if(DIR == 'L') {
				dir++;
				cnt--;
			}
			else {
				dir--;
				cnt++;
			}
			ballLoc = moveBall(N,arr,dir,bI,bJ);
			bI = ballLoc[0];
			bJ = ballLoc[1];
		}

		arr[bI][bJ] = 'L';
		StringBuilder res = new StringBuilder();
		//판 회전시키기
		if(cnt > 0){// 시계
			cnt = cnt %4;
			if(cnt==0) res = rollArr(N,arr,0);
			//한번돌림 A
			else if(cnt==1) res =  rollArr(N,arr,1);
			//두번돌림 B
			else if(cnt==2) res = rollArr(N,arr,2);
			//세번돌림 C
			else res = rollArr(N,arr,3);

		}
		else{// 반시계
			cnt = Math.abs(cnt)%4;
			if(cnt==0) res =  rollArr(N,arr,0);
			//한번돌림 C
			else if(cnt==1) res =  rollArr(N,arr,3);
			//두번돌림 B
			else if(cnt==2) res = rollArr(N,arr,2);
			//세번돌림 A
			else res = rollArr(N,arr,1);
		}

		System.out.println(res);
	}

	//막힐 때까지 공 이동시키는 메소드
	//위, 오른, 아래, 왼
	public static int[] moveBall(int N, char[][] arr, int dir, int I, int J){
		while(dir < 0){
			dir+=4;
		}
		dir = dir%4;
		while (I < N & I >=0 & J <N & I >=0){
			int nextI = I + dI[dir];
			int nextJ = J + dJ[dir];
			if(nextI >= N | nextI <0 | nextJ >=N | nextJ <0) break;
			if(arr[nextI][nextJ] == 'X') return new int[]{I,J}; // 중간에 막히면 그 위치 return
			I = nextI;
			J = nextJ;
		}
		return new int[]{I,J}; // 안 막히면 마지막 위치 return
	}

	//배열 회전시켜서 출력하는 메소드
	public static StringBuilder rollArr(int N, char[][] arr, int dir){
		StringBuilder sb = new StringBuilder();

		if(dir==0){
			for(int i = 0 ; i < N ; i++){
				for(int j = 0 ; j < N; j++){
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
		}else if(dir==1){
			for(int i = 0 ; i < N ; i++){
				for(int j = N-1 ; j>= 0 ; j--){
					sb.append(arr[j][i]);
				}
				sb.append('\n');
			}
		}else if(dir==2){
			for(int i = N-1 ; i >= 0 ; i--){
				for(int j = N-1 ; j>= 0 ; j--){
					sb.append(arr[i][j]);
				}
				sb.append('\n');
			}
		}else if(dir==3){
			for(int i = N-1 ; i >= 0 ; i--){
				for(int j = 0 ; j < N; j++){
					sb.append(arr[j][i]);
				}
				sb.append('\n');
			}
		}
		return sb;
	}
}
