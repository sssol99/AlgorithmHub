import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		String str = "";
		while((str = br.readLine()) != null){
			stk = new StringTokenizer(str);
			String c = stk.nextToken();
			String p = stk.nextToken();
			extracted(c, p);
		}
	}


	private static void extracted(String c, String p) {
		int idx = 0;
		for(int i = 0; i < p.length() ; i++){
			if(idx >= c.length()){
				break;
			}
			if(c.charAt(idx) == p.charAt(i)){
				//System.out.println(p.charAt(i));
				idx++;
			}
		}
		if(idx <c.length()) System.out.println("No");
		else  System.out.println("Yes");
		return;
	}
}
