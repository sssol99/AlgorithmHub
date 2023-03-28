import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		while(true){
			String s = br.readLine();
			if(s.equals("END")) break;
			StringBuffer tmpSb = new StringBuffer(s);
			sb.append(tmpSb.reverse()).append('\n');
		}
		System.out.println(sb);
	}
}
