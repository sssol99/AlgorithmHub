import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int alp[] = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};
		int sum = 0;
		for(int i = 0 ; i < s.length() ; i++){
			char tmp = s.charAt(i);
			sum+=alp[tmp-'A'];
		}
		System.out.println(sum%10%2 == 0 ? "You're the winner?" : "I'm a winner!");
	}
}


