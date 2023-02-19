import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][] miro;
	static int[][] mirocnt;
	static boolean[][] visit;
	static int I;
	static int J;

	static int[] dI = {-1,0,1,0};
	static int[] dJ = {0,1,0,-1};

	static class Node{
		int I;
		int J;

		public Node(int i, int j) {
			I = i;
			J = j;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		J = Integer.parseInt(stk.nextToken());
		I = Integer.parseInt(stk.nextToken());

		miro = new int[I][J];
		mirocnt = new int[I][J];
		visit = new boolean[I][J];

		for(int i = 0 ; i < I ; i++){
			String tmp = br.readLine();
			for(int j = 0 ; j < J ; j++){
			miro[i][j] = tmp.charAt(j)-'0';
				mirocnt[i][j] = 9999999;
			}
		}

		Deque<Node> dq = new ArrayDeque<>();
		dq.add(new Node(0,0));
		mirocnt[0][0] = 0;

		while(!dq.isEmpty()){
			Node node = dq.pollFirst();
			int i = node.I;
			int j = node.J;

			if(i==I-1 & j== J-1) break;

			if(visit[i][j]) continue;
			visit[i][j] = true;

			for(int d = 0 ; d < 4 ; d++){
				int nextI = i + dI[d];
				int nextJ = j + dJ[d];

				if(nextI < 0 | nextJ < 0 | nextI >= I | nextJ >=J) continue;
				if(visit[nextI][nextJ]) continue;

				if(mirocnt[nextI][nextJ] > mirocnt[i][j]+miro[nextI][nextJ]){
					mirocnt[nextI][nextJ] = mirocnt[i][j]+miro[nextI][nextJ];
					if(miro[nextI][nextJ] == 1) dq.addLast(new Node(nextI,nextJ));
					else dq.addFirst(new Node(nextI,nextJ));

				}
			}
		}
		System.out.println(mirocnt[I-1][J-1]);
	}
}
