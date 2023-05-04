public class Main {
	public static void main(String[] args) throws Exception {
		int N = read();
		int S = read();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = read();
		}
		int s = 0;
		int e = 1;
		long sum = arr[0];
		int num = 1;
		int res = Integer.MAX_VALUE;
		while(s<=e & s < arr.length){
			if(sum >= S) res = Integer.min(res,num);

			if(e >= arr.length) {
				sum -= arr[s];
				s++;
				num--;
				continue;
			}
			if(sum < S){
				sum += arr[e];
				e++;
				num++;

			}
			else {
				sum -= arr[s];
				s++;
				num--;
			}

		}
		if(res == Integer.MAX_VALUE) System.out.println(0);
		else System.out.println(res);

	}

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}