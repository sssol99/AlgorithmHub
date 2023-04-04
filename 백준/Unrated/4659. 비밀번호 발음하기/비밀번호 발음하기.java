import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ac ="is acceptable.";
		String nc = "is not acceptable.";
		StringBuilder sb = new StringBuilder();
		while(true){
			String s = br.readLine();
			String now = s;
			if(s.equals("end")) break;


			String next= s.replaceAll("a|e|i|o|u","");
			if(next.length() == s.length()) {
				sb.append("<"+now+"> "+nc).append('\n');
				continue;
			}


			next= s.replaceAll("[a|e|i|o|u]{3}","").replaceAll("[^a|e|i|o|u]{3}","");
			if(next.length() != s.length()) {
				sb.append("<"+now+"> "+nc).append('\n');
				continue;
			}

			next = s.replaceAll("([a-df-np-z])\\1","");
			if(next.length() != s.length()) {
				sb.append("<"+now+"> "+nc).append('\n');
				continue;
			}

			sb.append("<"+now+"> "+ac).append('\n');

		}
		System.out.println(sb);
	}
}

