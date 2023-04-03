import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	static int N; // 도시의 수
	static int M; // 길 수
	static int K; // 좀비도시 수
	static int S; // 좀비범위 수
	static int P; // 안전도시
	static int Q; // 위험도시

	static class Node implements Comparable<Node>{
		int ed;
		long cost;

		public Node(int ed, long cost) {
			this.ed = ed;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.cost,o.cost);
		}
	}
	//0-1BFS
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		S = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		P = Integer.parseInt(stk.nextToken()); // 안전도시
		Q = Integer.parseInt(stk.nextToken()); // 위험도시

		ArrayList<Integer> zomibeCitys = new ArrayList<>(); // 좀비 도시
		ArrayList<Integer>[] roads = new ArrayList[N+1]; // 길 저장

		for(int i = 0 ; i < N+1 ; i++) roads[i] = new ArrayList<>();


		for(int i = 0 ; i < K ; i++) zomibeCitys.add(Integer.parseInt(br.readLine()));

		for(int i = 0 ; i < M ; i++) {
			stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			roads[st].add(ed);
			roads[ed].add(st);
		}

		int[] citys = new int[N+1]; // 위험지역
		boolean[] nocitys = new boolean[N+1]; //못가는곳

		for(int i = 0 ; i < zomibeCitys.size() ; i++){
			nocitys[zomibeCitys.get(i)] = true;
		}

		goRoad(roads,citys,zomibeCitys);

		for(int i = 1 ; i < N ; i++){
			if(citys[i] == 0) citys[i] = P;
		}

		citys[1] = 0;
		citys[N] = 0;

		long res = dktr(roads,citys,nocitys);
		System.out.println(res);

	}

	//좀비도시찾는 메서드(BFS)
	static void goRoad(ArrayList<Integer>[] roads, int[] citys , ArrayList<Integer> zomibeCitys ){

		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N+1];

		for(int i = 0 ; i < zomibeCitys.size() ; i++){
			q.add(zomibeCitys.get(i));
			visited[zomibeCitys.get(i)] = true;
		}
		int count = 0;
		while(!q.isEmpty()){

			int size = q.size();

			//fori
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				citys[now] = Q;
				if(count == S) continue;
				for (int j = 0; j < roads[now].size(); j++) {
					int next = roads[now].get(j);
					if(visited[next]) continue;
					q.add(next);
					visited[next] = true;
				}
			}
			count++;

		}

	}

	// 다익스트라
	static long dktr( ArrayList<Integer>[] roads, int[] city, boolean[] Zombiecitys){
		boolean[] visited = new boolean[N+1];
		long[] dis = new long[N+1];

		for(int i = 0 ; i < N+1 ; i++) dis[i] = 990000000000L;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));
		dis[1] = 0;

		while(!pq.isEmpty()){
			Node now = pq.poll();
			if(now.ed == N) return now.cost;
			if(visited[now.ed]) continue;
			visited[now.ed] = true;

			for(int i = 0 ; i < roads[now.ed].size() ; i++){
				int next = roads[now.ed].get(i);
				//if(visited[next]) continue; // 방문했으면 continue;
				if(Zombiecitys[next]) continue; // 좀비도시면 continue;
				if(dis[now.ed]+city[next] >= dis[next]) continue;
				dis[next] = dis[now.ed]+city[next];
				pq.add(new Node(next,dis[next]));
			}
		}
		return 0;
	}


}

