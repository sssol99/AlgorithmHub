import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int idx = 0;
	static int N;
	public static void main(String[] args) throws Exception {
		N = read(); // N번째 감소하는 수
		System.out.println(BFS());
	}

	public static Long BFS(){
		Queue<Long> q = new LinkedList<>();
		for(int i = 0 ; i <= 9 ; i++) q.add((long) i);
		while(!q.isEmpty()){
			long now = q.poll();
			//System.out.println(now);
			if(idx > 100_0000) break;
			if(idx == N) return now;
			idx++;
			for(int i = 0 ; i <= 9 ; i++){
				if(now <= 9) {
					if (now > i) q.add(now*10+i);
				}else {
					if (now%10 > i) q.add(now*10+i);
				}
			}
		}
		return (long) -1;

	}

	public static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}


