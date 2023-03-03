import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dI = {1,0};
	static int[] dJ = {0,1};

	static int I;

	static int J;

	static int paper[][];

	static int ressum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		I = Integer.parseInt(stk.nextToken());
		J = Integer.parseInt(stk.nextToken());

		ressum = 0;

		paper = new int[I][J];

		for(int i = 0 ; i < I ; i++){
			String tmp = br.readLine();
			//stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < J ; j++){
				paper[i][j] = tmp.charAt(j) - '0';
				//paper[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		DFS(0,I*J, 0,0,"");
		System.out.println(ressum);
	}

	public static void DFS(int cnt, int maxCnt, int ck , int sum, String what){

				if(cnt==maxCnt) {
					//System.out.println(what + "sum :  "+sum);
					ressum = Integer.max(sum,ressum);
					return;
				}

				int i = cnt/J;
				int j = cnt%J;

				//ck안되어있으면 continue;
				if((ck & 1 << cnt) != 0){
					DFS(cnt+1, maxCnt,ck,sum, what+" ");
					return;
				}

				ck = ck | 1 << cnt;

				int tmp = paper[i][j];

				// 1개로 자르기
				DFS(cnt+1, maxCnt,ck,sum+tmp, what+" "+tmp);
				int tmptmp = tmp;
				int ckck = ck;
				//아래로 자르기 -> 옆으로 자르기
				for(int k = 0 ; k < 2 ; k++){
					//2,3,4개로 자르기
					int maxdir = k == 0 ? I : J;
					tmp = tmptmp;
					ck = ckck;
					for(int m = 1 ; m < maxdir ; m++){ //m =
						int nextI = i+dI[k]*m;
						int nextJ = j+dJ[k]*m;

						if(nextI <0 | nextI >= I | nextJ <0 | nextJ >=J) break;

						int next = nextI *J + nextJ;

						//다음에 갈 곳이 이미 방문된 곳이면
						if((ck & 1 << next) !=0) {
							return;
						}

						tmp =  tmp*10 + paper[nextI][nextJ];
						DFS(cnt+1, maxCnt,ck = ck | 1 << next,sum+tmp, what+" "+tmp);
					}
				}
	}
}
