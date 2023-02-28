import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static ArrayList<Node> arr;

	static int costs[];
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}

	//합치는 알고리즘
	public static void union(int a, int b){
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		if(rootA!=rootB) costs[rootB] = rootA;
	}

	//대표 찾는 알고리즘
	public static int findRoot(int now){
		if(costs[now]!=now) costs[now] = findRoot(costs[now]);
		return costs[now];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();


		for(int i = 0 ; i < M ; i++){
			stk = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());

			arr.add(new Node(s,e,c));
		}

		Collections.sort(arr);

		costs = new int[N+1];

		//유니온 루트노드 초기화
		for(int i = 1 ; i < N+1 ; i++){
			costs[i] = i;
		}

		int res = 0;

		for (Node node : arr) {
			if(findRoot(node.start) != findRoot(node.end)){
				res+=node.cost;
				union(node.start, node.end);
			}
		}
		System.out.println(res);
	}
}
