import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Bridge{
		int s;
		int e;

		public Bridge(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
	public static void main(String[] args) throws Exception {
		int N = read();

		int inCnt[] = new int [N+1];

		for(int i = 0 ; i < N-1 ; i++){
			int s = read();
			int e = read();

			inCnt[e] ++;
			inCnt[s] ++;
		}

		int q = read();

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < q ; i++){
			int t =  read();
			int k =  read();
			if(t==2) {
				sb.append("yes").append('\n');
				continue;
			}

			if(inCnt[k]==1) sb.append("no").append('\n');
			else sb.append("yes").append('\n');
		}
		System.out.println(sb);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}
