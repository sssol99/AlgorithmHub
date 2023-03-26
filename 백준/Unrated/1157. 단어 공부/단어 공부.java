
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toUpperCase();
		int alp[] = new int[26];

		for(int i = 0 ; i < s.length() ; i++){
			alp[s.charAt(i)-'A']++;
		}

		char now = 'A';
		int cnt = alp[0];
		for(int i = 1 ; i < 26 ; i++){
			if(cnt == alp[i]) now = '?';
			if(cnt < alp[i]) {
				now = (char) (i+'A');
				cnt = alp[i];
			}
		}
		System.out.println(now);
	}
}
