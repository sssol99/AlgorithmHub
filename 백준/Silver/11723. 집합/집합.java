import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int bit = 0;
		StringBuilder sb = new StringBuilder();

		for(int i = 0 ; i < N ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			String nowM = stk.nextToken();
			switch (nowM){
				case "add" :
					int nowAdd = Integer.parseInt(stk.nextToken())-1;
					bit = bit | (1<<(nowAdd));
					break;
				case "remove" :
					int nowRemove = Integer.parseInt(stk.nextToken())-1;
					bit = bit & ~(1<<(nowRemove));
					break;
				case "check" :
					int nowCheck = Integer.parseInt(stk.nextToken())-1;
					if ( (bit & (1<<(nowCheck)))==0) sb.append(0).append('\n');
					else sb.append(1).append('\n');
					break;
				case "toggle" :
					int nowToggle = Integer.parseInt(stk.nextToken())-1;
					bit ^= (1<<(nowToggle));
					break;
				case "all" :
					bit = (1<<21)-1;
					break;
				case "empty" :
					bit = 0;
					break;
			}
		}
		System.out.println(sb);
	}
}
