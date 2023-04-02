import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		for(int i = 0 ; i < N ; i++){
			res += isGroupWord(br.readLine());
		}
		System.out.println(res);
	}
	public static int isGroupWord(String s){
		boolean[]alp = new boolean[26];
		char before = s.charAt(0);
		alp[before-'a'] = true;
		for(int j = 1 ; j < s.length() ; j++){
			char now = s.charAt(j);
			if(before == now) continue;
			if(alp[now-'a'] == true) return 0;
			alp[now-'a'] = true;
			before = now;
		}
		return 1;
	}
}

