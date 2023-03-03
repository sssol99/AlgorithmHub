
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int I;
	static int J;

	static boolean[][] room;

	static boolean[][] clean;

	static int dir;

	static int[] dI = {-1,0,1,0};
	static int[] dJ = {0,1,0,-1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		I = Integer.parseInt(stk.nextToken());

		J = Integer.parseInt(stk.nextToken());

		room = new boolean[I][J];

		clean = new boolean[I][J];

		stk = new StringTokenizer(br.readLine());

		int nowI = Integer.parseInt(stk.nextToken());
		int nowJ = Integer.parseInt(stk.nextToken());
		dir = Integer.parseInt(stk.nextToken());

		for(int i = 0 ; i < I ; i++){
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j  < J  ; j++){
				 if(stk.nextToken().equals("1")) {
					 room[i][j]  = true;
					 clean[i][j] = true;
				 }
			}
		}


		int cnt = 0;

		while(true){
			//현재 칸이 아직 청소되지 않은 경우
			//cnt++;
			if(!clean[nowI][nowJ]) {
				cnt++;
				clean[nowI][nowJ] = true;
			}

			//현재 칸의 주변 4칸 중 청소할곳 있는경우
			if(findNotCleanRoom(nowI,nowJ)){
				//반시계 방향으로 90도 회전했을때
				dir = (dir+4-1)%4;
				//청소하지 않은 곳이면 전진 continue;

				int nextI = nowI+dI[dir];
				int nextJ = nowJ+dJ[dir];

				if(nextI <0 | nextI >= I | nextJ <0 | nextJ >=J) continue;
				//아직 청소 안했고, 벽이 아니면
				if(clean[nextI][nextJ]) continue;
				if(room[nextI][nextJ]) continue;


				nowI = nextI;
				nowJ = nextJ;


			}//주변 4칸 중 청소할곳 없는경우
			else{
				//후진할 수 있으면 후진
				int nextI = nowI-dI[dir];
				int nextJ = nowJ-dJ[dir];

				if(nextI <0 | nextI >= I | nextJ <0 | nextJ >=J) continue;
				if(room[nextI][nextJ]) break;
				//후진할 수 없으면 break;

				nowI = nextI;
				nowJ = nextJ;
			}
		}

		System.out.println(cnt);
	}
	//청소할곳 찾는 메소드
	public static boolean findNotCleanRoom(int nowI, int nowJ){
		for(int i = 0 ; i < 4; i++){
			int nextI = nowI+dI[i];
			int nextJ = nowJ+dJ[i];

			if(nextI <0 | nextI >= I | nextJ <0 | nextJ >=J) continue;
			if(!clean[nextI][nextJ]) return true;
		}
		return false;
	}

}
