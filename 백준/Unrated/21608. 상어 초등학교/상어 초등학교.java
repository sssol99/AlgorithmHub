import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	class Node implements Comparable<Node>{
		int I;
		int J;
		int cost;

		public Node(int i, int j, int cost) {
			I = i;
			J = j;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}

	static int[] dI = {-1,0,1,0};
	static int[] dJ = {0,1,0,-1};

	static int[][] arr; // 자리에 앉는거

	static int N;
	public static void main(String[] args) throws Exception {
		N = read();
		int[][] classes = new int[N+1][N+1]; // 교실
		arr = new int[N+1][N+1];
		Set<Integer> likes[] = new HashSet[N*N+1]; // 좋아하는 학생 기록할 배열
		for(int i = 0 ; i <N*N+1 ; i++ ) likes[i] = new HashSet<>();
		for(int i = 1 ; i <= N*N ; i++){
			int student = read(); // 학생 넘버
			int[] like = new int[4]; // 좋아하는 학생들
			for(int j = 0 ; j < 4 ; j++){
				likes[student].add(read());
			}

			//1. 비어있는 칸 중 좋아하는 학생이 가장 많이 인접해 있는 칸을 선택한다
			ArrayList<int[]> sit1 = findLikeStudent(likes,student);

			if(sit1.size() == 1) {
				int I = sit1.get(0)[0];
				int J = sit1.get(0)[1];

				arr[I][J] = student;
			}

			//2. 1중에서 주변 자리 중 비어 있는 칸이 가장 많은 칸을 선택한다
			//3. 2 중에서 행,열이 가장 작은 칸을 선택한다.
			ArrayList<int[]> sit2 = findBlank(sit1);
			int I = sit2.get(0)[0];
			int J = sit2.get(0)[1];

			arr[I][J] = student;

		}
		//4. 만족도 구하기
		System.out.println(sumsatisfaction(likes));



	}

	//1
	static ArrayList<int[]> findLikeStudent(Set<Integer> likes[], int num){ // 좋아하는 학생배열, 현재학생숫자
		int maxCnt = 0;


		int ckCnt[][] = new int[N+1][N+1]; // 인접한 칸 수 저장할 배열
		//2차원 배열에 인접한 칸은 int 늘리기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				//좋아하는 학생이면
				if(arr[i][j]>0 & likes[num].contains(arr[i][j])) {
					for(int d = 0 ; d < 4 ; d++){
						int nextI = i+dI[d];
						int nextJ = j+dJ[d];

						if(nextI <= 0 | nextI > N | nextJ <= 0 | nextJ >N) continue;

						if(arr[nextI][nextJ] > 0) continue;
						ckCnt[nextI][nextJ] ++;
						maxCnt = Integer.max(maxCnt,ckCnt[nextI][nextJ]); // max 값 갱신
					}
				}//좋아하는 학생이 아니면
				else{
					if(arr[i][j] > 0) continue; // 이미 차있으면 continue
					ckCnt[i][j]++;
					maxCnt = Integer.max(maxCnt,ckCnt[i][j]);// max 값 갱신
				}
			}
		}

		ArrayList<int[]> sit1 = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (ckCnt[i][j] == maxCnt) {
					sit1.add(new int[]{i,j});
				}
			}
		}

		return sit1;
	}

	//2
	static ArrayList<int[]> findBlank(ArrayList<int[]> sit1){
		ArrayList<int[]> sit2 = new ArrayList<>();
		int maxBlankCnt = 0;
		//2차원 배열에 비어있는 칸 저장
		for (int i = 0; i < sit1.size(); i++) {
			int nowCnt = 0;
			int I = sit1.get(i)[0];
			int J = sit1.get(i)[1];
			for(int d = 0 ; d < 4 ; d++){
				int nextI = I+dI[d];
				int nextJ = J+dJ[d];

				if(nextI <= 0 | nextI > N | nextJ <= 0 | nextJ >N) continue;

				if(arr[nextI][nextJ] == 0) nowCnt++;
			}

			if(nowCnt > maxBlankCnt){
				sit2 = new ArrayList<>();
				sit2.add(new int[]{I,J});
				maxBlankCnt = nowCnt;
			}else if(nowCnt == maxBlankCnt){
				sit2.add(new int[]{I,J});
			}
		}
		return sit2;
	}

	static int sumsatisfaction(Set<Integer> likes[]){
		int likeGrade[] = {0,1,10,100,1000};
		int res = 0;
		//배열 쭉 돌면서 체크
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int cnt = 0;
				for(int d = 0 ; d < 4 ; d++){
					int nextI = i+dI[d];
					int nextJ = j+dJ[d];

					if(nextI <= 0 | nextI > N | nextJ <= 0 | nextJ >N) continue;
					if(likes[arr[i][j]].contains(arr[nextI][nextJ])) {
						cnt++;
					}

				}
				res+=likeGrade[cnt];
			}
		}
		return res;
	}



	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}

