import javax.xml.soap.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int start;
		int cost;
		public Node(int start, int cost) {
			this.start = start;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if(this.cost-o.cost >0 )return 1;
			else return -1;
		}
	}
	

	static int[][] nodes;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken()); // 정점개수
		int E = Integer.parseInt(stk.nextToken()); //간선개수

		nodes = new int[N+1][N+1];

		for(int i = 0 ; i <=N ; i++){
			Arrays.fill(nodes[i],Integer.MAX_VALUE);
		}

		for(int i = 0 ; i < E ; i++){
			stk = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			nodes[s][e] = Integer.min(nodes[s][e],c);
			nodes[e][s] = Integer.min(nodes[e][s],c);
		}
		
		stk = new StringTokenizer(br.readLine());

		int node1 = Integer.parseInt(stk.nextToken());
		int node2 = Integer.parseInt(stk.nextToken());

		int res1 = -1;
		int res2 = -1;

		// 1 -> 노드1 -> 노드2 -> N
		int tmp1 = dykstra(1,node1);
		int tmp2 = dykstra(node1,node2);
		int tmp3 = dykstra(node2,N);
		
		if(tmp1 == 999999999 | tmp2 == 999999999 | tmp3 == 999999999) res1 = -1;
		else res1 = tmp1+tmp2+tmp3;

		 tmp1 = dykstra(1,node2);
		 tmp2 = dykstra(node2,node1);
		 tmp3 =dykstra(node1,N);

		if(tmp1 == 999999999 | tmp2 == 999999999 | tmp3 == 999999999) res2 = -1;
		else res2 = tmp1+tmp2+tmp3;

		if(res1==-1){
			if(res2==-1){
				System.out.println(-1);
			}else{
				System.out.println(res2);
			}
		}else if(res2==-1){
			if(res1==-1){
				System.out.println(-1);
			}else{
				System.out.println(res1);
			}
		}else{
			System.out.println(Long.min(res1,res2));
		}
	}

	public static int dykstra(int s, int e){
		PriorityQueue<Node> q = new PriorityQueue<>();
		int[] dis = new int[N+1];
		boolean[] visited = new boolean[N+1];

		Arrays.fill(dis,999999999);

		dis[s] = 0;
		q.add(new Node(s,0));

		while (!q.isEmpty()){
			Node node = q.poll();
			if(visited[node.start]) continue;

			visited[node.start] = true;

			for(int i = 1 ; i <= N ; i++){
				if(visited[i]) continue;
				if(nodes[node.start][i]==Integer.MAX_VALUE) continue;
				if(node.cost + nodes[node.start][i] >= dis[i]) continue;
				dis[i] = node.cost + nodes[node.start][i];
				q.add(new Node(i,dis[i]));
			}
		}
			return dis[e];
	}

}
