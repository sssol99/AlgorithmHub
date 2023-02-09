import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		public Node(int start, int cost){
			this.start = start;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 도시의 개수
		int M = Integer.parseInt(br.readLine()); // 버스의 개수

		//간선 ArrayList 배열에 저장 ( 2번도시에서 출발하는 모든 곳은 arr[2].get(n))
		ArrayList<Node>[] bus = new ArrayList[1001]; // 버스 저장할 배열리스트

		for(int i = 0 ; i < 1001 ; i++) {
			bus[i] = new ArrayList<>();
		}

		for(int i = 0 ; i < M ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());

			bus[start].add(new Node(start, end, cost));
		}


		//visited 도시 방문체크 배열
		boolean visited[] = new boolean[N+1];
		//최소비용 저장할 배열
		int costs[] = new int[N+1];
		Arrays.fill(costs,987654321);
		//방문해야할 곳 넣을 pq
		PriorityQueue<Node> pq = new PriorityQueue();

		StringTokenizer stk = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(stk.nextToken());
		int end = Integer.parseInt(stk.nextToken());

		costs[start] = 0;

		for(int i = 0 ; i < bus[start].size() ; i++){
			Node node = bus[start].get(i);
			pq.add(new Node(node.end , node.cost));

			costs[node.end] = Integer.min(costs[node.end], node.cost+costs[node.start]);
		}

		while(!pq.isEmpty()){

			Node node = pq.poll();

			if(visited[node.start]) continue;

			visited[node.start] = true;
			//현재 위치에서
			for(int i = 0 ; i < bus[node.start].size() ; i++){
				Node tmp = bus[node.start].get(i);
				if(visited[tmp.end]) continue;
				costs[tmp.end] = Integer.min(costs[tmp.end], tmp.cost+node.cost);
				pq.add(new Node(tmp.end, costs[tmp.end]));
			}


		}

		System.out.println(costs[end]);
	}
}