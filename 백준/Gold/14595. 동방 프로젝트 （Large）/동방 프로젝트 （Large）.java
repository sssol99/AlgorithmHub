import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	static class Node implements Comparable<Node>{
		int s;
		int e;

		public Node(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Node o) {

			return this.s - o.s;
		}
	}
	static int N; // 동아리방의 개수
	static int M; // 음이 아닌 정수(종빈이의 행동수)

	static int[] root;
	static int[] rank; // 낮은게 높은곳의 자식으로 들어가는게 이득

	//합치는 메서드
	static void union(int a, int b){
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		if(rootA == rootB) return;

		root[rootA] = rootB;
		 //b가 더 낮은 경우, a의 자식에 추가
//		if(rank[rootA] < rank[rootB]) root[rootA] = rootB;
//		// a 가 더 낮은 경우, b의 자식에 추가
//		else if(rank[rootA] > rank[rootB]) root[rootB] = root[rootA];
//		else if(rank[rootA] == rank[rootB]){
//			root[rootA] = rootB;
//			rank[rootB]++;
//		}

	}

	//부모 리턴해주는 메서드
	static int findRoot(int a){
		if(a != root[a]) root[a] = findRoot(root[a]);
		return root[a];
	}

	public static void main(String[] args) throws Exception {

		N = read();
		M = read();

		//root 초기화
		root = new int[N+1];
		rank = new int[N+1];
		for (int i = 0; i < N+1; i++) {
			root[i] = i;
		}

		ArrayList<Node> arr = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			int a = read();
			int b = read();
			arr.add(new Node(a,b));
			//이미 부순곳은 뛰어넘기
//			for (int j = findRoot(a); j < b; j++) {
//
//				union(j,j+1);
//			}
		}
		int end = 0;

//
		Collections.sort(arr);
		for (int i = 0; i < M; i++) {

			int a = Math.max(arr.get(i).s, end);
			for (int j = a; j <= arr.get(i).e; j++) {
				union(a, j);
			}
			end = Math.max(end, arr.get(i).e);
		}
		
		
		Set<Integer> set = new HashSet<>();

		for (int i = 1; i < N + 1; i++) {
			set.add(findRoot(root[i]));
		}

		System.out.println(set.size());
	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}

