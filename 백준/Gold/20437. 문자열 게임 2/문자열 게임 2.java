import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0 ; t < T ; t++){
			int shortS = Integer.MAX_VALUE;
			int longS = Integer.MIN_VALUE;

			String s = br.readLine();
			int K = Integer.parseInt(br.readLine());

			if(K==1){
				sb.append(1).append(" ").append(1).append('\n');
				continue;
			}

			ArrayList<Integer>[] alp = new ArrayList[26];

			for(int i = 0 ; i < 26 ; i++){
				alp[i] = new ArrayList<>();
			}

			for(int i = 0 ; i < s.length() ; i++){
				alp[s.charAt(i)-'a'].add(i);
			}

			for(int i = 0 ; i < 26 ; i++){
				for(int j = 0 ; j < alp[i].size() ; j++){
					if(j+K-1 >= alp[i].size()) break; // j ~ j+K-1 -> K개

					shortS = Integer.min(shortS, alp[i].get(j+K-1) - alp[i].get(j) +1);
					longS = Integer.max(longS, alp[i].get(j+K-1) - alp[i].get(j) +1);

				}
			}

			if(shortS==Integer.MAX_VALUE) sb.append(-1).append('\n');
			else sb.append(shortS).append(" ").append(longS).append('\n');
		}

		System.out.println(sb);
	}
}

