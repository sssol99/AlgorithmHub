import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		int N = read();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i < N ; i++) pq.add(read());

		int res = 0;
		while(pq.size() > 1){
			Integer card1 = pq.poll();
			Integer card2 = pq.poll();

			Integer sum = card1+card2;
			res+= sum;
			pq.add(sum);
		}
		System.out.println(res);
	}


	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
