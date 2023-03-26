import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception {


			N = read();
			int lv = findLv();
			System.out.println(lv+1);


	}

	static int findLv(){
		if(N==1) return 0;
		int a = 1;
		int idx = 1;
		while(true){
			a+=6*idx;
			if(a >= N){
				return idx;
			}
			idx++;
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
