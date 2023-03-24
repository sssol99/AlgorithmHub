public class Main {

	public static void main(String[] args) throws Exception {
		int N = read();
		int cards[] = new int[N+1];
		for(int i = 1 ; i <= N ; i++) cards[i] = read();

		for(int i = 1 ; i <= N ; i++){
			for(int j = 1 ; j <= i/2 ; j++){
				cards[i] = Integer.max(cards[i],cards[j] + cards[i-j]);
			}
		}
		System.out.println(cards[N]);
	}
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
