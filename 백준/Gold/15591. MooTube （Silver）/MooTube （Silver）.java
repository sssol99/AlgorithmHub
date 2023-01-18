import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken()); // 무튜브 수
		int Q = Integer.parseInt(stk.nextToken()); // Q개의 질문

		ArrayList<Node>[] arr = new ArrayList[N+1];

		for(int i = 0 ; i < N+1 ; i++){
			arr[i] = new ArrayList<>();
		}

		for(int i = 0 ; i < N-1 ; i++){
			stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			int usado = Integer.parseInt(stk.nextToken());

			arr[st].add(new Node(ed,usado));
			arr[ed].add(new Node(st,usado));
		}


		//첫번째 행 : 시작점  &
		int[][] minUsado = new int[N+1][N+1]; //이차원 배열 : 유사도 최소 비용 담을 배열



		//다익스트라 N번 돌리기 시작!
		for(int i = 1 ; i < N+1 ; i++){ // 1번에서 2,3,4의 유사도
			boolean[] visitedNode = new boolean[N+1]; //pq로 빼올때 방문한 건 처리하면 안되니까

			Arrays.fill(minUsado[i],Integer.MAX_VALUE);

			//다익스트라 시작!
			PriorityQueue<Node> pq = new PriorityQueue<>();

			//시작 노드 설정
			pq.add(new Node(i,Integer.MAX_VALUE));
			minUsado[i][i] = Integer.MAX_VALUE;

			while(!pq.isEmpty()){
				Node nowNode = pq.poll();
				int des = nowNode.des;
				int usado = nowNode.usado;

				//방문 체크 -> pq에서 des 가 2, 유사도가 5인게 들어갔다고 가정해 보자. 아직 pq 에 남아 있는데 des2, 유사도 5인게 나왔다고 치자. 유사도 적은게 어차피 먼저 pq 처리 되었을 테니까 처리할 필요가 없다.
				//if(minUsado[i][des] < usado) continue;

				//현재 위치에서 이어지는 곳 체크
				for (Node n: arr[des]) {
					int nDes = n.des;
					int nUsado = n.usado;


					if(visitedNode[nDes]) continue;

					visitedNode[nDes] = true;

					int min = Math.min(nUsado,minUsado[i][des]);
					minUsado[i][nDes] = min;



					pq.add(new Node(nDes,min));
				}
			}
		}

		for(int i = 0 ; i < Q ; i++){
			stk = new StringTokenizer(br.readLine());

			int q = Integer.parseInt(stk.nextToken());
			int p = Integer.parseInt(stk.nextToken());

			int cnt = 0 ;

			for(int j = 1 ; j < N+1 ; j++){
				if(p==j) continue;
				if ( q <= minUsado[p][j]) cnt++;
			}
			System.out.println(cnt);
		}



	}

	static class Node implements Comparable<Node> {
		int des; //목적지
		int usado; //비용

		public Node(int des, int usado) {
			this.des = des;
			this.usado = usado;
		}

		@Override
		public int compareTo(Node o) {
			if(this.usado < o.usado) return -1;
			else return 1;
		}
	}
}

