
public class Main {
	static int I;
	static int J;
	static int K;

	static boolean[][] arr;
	static boolean[][] ck;

	static int[] dI = {-1,0,1,0};
	static int[] dJ = {0,1,0,-1};

	static int MAX = 1;
	static int tmpMAX;

	public static void main(String[] args) throws Exception {
		I = read();
		J = read();
		K = read(); // 음식물의 개수
		arr = new boolean[I+1][J+1];
		ck = new boolean[I+1][J+1];

		for(int i = 0 ; i < K ; i++){
			int II = read();
			int JJ = read();
			arr[II][JJ] = true;
		}

		for(int i = 1 ; i <= I ; i++){
			for(int j = 1 ; j <= J ; j++){
				if(ck[i][j]) continue;
				ck[i][j] = true;
				if(!arr[i][j]) continue;
				tmpMAX = 1;
				DFS(i,j);
			}
		}

		System.out.println(MAX);
	}

	static void DFS(int i, int j){
		MAX = Integer.max(MAX,tmpMAX);
		for(int k = 0 ; k < 4 ; k++){
			int nextI = i+dI[k];
			int nextJ = j+dJ[k];

			if(nextI < 0 | nextI > I | nextJ < 0 | nextJ >J) continue;
			if(ck[nextI][nextJ]) continue;
			if(!arr[nextI][nextJ]) continue;
			ck[nextI][nextJ] = true;

			tmpMAX++;
			DFS(nextI,nextJ);
		}
	}
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
