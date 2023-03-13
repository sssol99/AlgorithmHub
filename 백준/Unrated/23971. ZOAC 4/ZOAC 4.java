
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		int tI = read();
		int tJ = read();
		int bI = read()+1;
		int bJ = read()+1;

		int left = tI / bI;
		int right = tJ / bJ;
		if (tI % bI !=0) left++;
		if (tJ % bJ !=0) right++;

		System.out.println(left*right);
	}

	public static int read() throws Exception{
		int c,n = System.in.read() & 15;
		while((c = System.in.read()) > 32)
			n = (n<<3) + (n<<1) + (c&15);
		return n;
	}
}
