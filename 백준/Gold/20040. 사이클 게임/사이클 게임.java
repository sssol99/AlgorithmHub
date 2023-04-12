public class Main {
	static int N;
	static int root[];
	public static void main(String[] args) throws Exception {
		N = read();
		root = new int[N];
		int M =read();
		//root 초기화
		for (int i = 0; i < N; i++) {
			root[i] = i;
		}

		for (int i = 1; i <= M; i++) {
			int st = read(); // 시작점
			int ed = read(); // 끝점

			if(!isSameRoot(st,ed)) {
				System.out.println(i);
				System.exit(0);
			}
		}

		System.out.println(0);

	}

	//a의 루트를 찾아주는 메소드
	private static int findRoot(int a){
		if(root[a] != a)
			root[a] = findRoot(root[a]);
		return root[a];
	}


	//a와 b를 합하는 메소드
	private static boolean isSameRoot(int a, int b){
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		if(rootA == rootB) return false;
		else root[rootB] = rootA;
		return true;
	}



	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}

