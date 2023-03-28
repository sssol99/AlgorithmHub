import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TK = Integer.parseInt(br.readLine());

		for(int t = 0 ; t < TK ; t++){
			int[] alp = new int[26];
			String s = br.readLine().replace(" ","");
			for(int i = 0 ; i < s.length() ; i++){
				alp[s.charAt(i)-'a']++;
			}


			int maxCnt = alp[0];
			char nowAlp = 'a';
			for(int i = 1 ; i < 26 ; i++){
				if(maxCnt < alp[i]){
					maxCnt = alp[i];
					nowAlp = (char)(i+'a');
				}else if(maxCnt == alp[i]){
					nowAlp = '?';
				}
			}
			System.out.println(nowAlp);
		}
	}
}
