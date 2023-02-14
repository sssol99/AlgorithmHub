import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static  ArrayList<Node> tree[];

	static int maxCost;

	static int A;
	static class  Node{
		int end;
		int cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		tree = new ArrayList[N+1];

		for(int i = 0 ; i <= N ; i++){
			tree[i] = new ArrayList<>();
		}


		for(int i = 0 ; i < N-1 ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			int cost = Integer.parseInt(stk.nextToken());

			tree[start].add(new Node(end,cost));
			tree[end].add(new Node(start,cost));
		}
		boolean[] tmp = new boolean[N+1];
		tmp[1] = true;
		DFS(1,0,tmp);
		int B = A;
		maxCost = 0;
		A = 0;
		tmp = new boolean[N+1];
		tmp[B] = true;
		DFS(B,0,tmp);

		//A->B

		findDiameter(A,B,0,new boolean[N+1]);

	}

	public static void DFS(int start, int cost, boolean[] ck){
		if(cost > maxCost){
			maxCost = cost;
			A = start;
		}

		for(int i = 0 ; i < tree[start].size() ; i++){
			if(ck[tree[start].get(i).end]) continue;
			ck[tree[start].get(i).end] = true;
			DFS(tree[start].get(i).end,cost+tree[start].get(i).cost,ck);
			ck[tree[start].get(i).end] = false;
		}

	}

	public static void findDiameter(int start, int des, int cost, boolean[] ck){
		if(start==des){
			System.out.println(cost);
			System.exit(0);
		}

		for(int i = 0 ; i < tree[start].size() ; i++){
			if(ck[tree[start].get(i).end]) continue;
			ck[tree[start].get(i).end] = true;
			findDiameter(tree[start].get(i).end, des,cost+tree[start].get(i).cost,ck);
			ck[tree[start].get(i).end] = false;
		}

	}
}
