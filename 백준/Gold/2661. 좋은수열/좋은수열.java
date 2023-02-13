import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		DFS(0,"");
	}

	//lv :2 s : 12
	private static void DFS(int lv, String s) {
		
		
		//좋은 순열인지 체크 1 -> 끝에서부터 인접한 묹
		//ex ) 1313131 이면 ->1 , 31, 131, 3131, 13131, 313131, 1313131 
		for(int i = s.length()-1 ; i > ((s.length()-1)/2 ); i--) {
			String goodS = s.substring(i,s.length());  			
			String frontS = s.substring(i-goodS.length(),i);

			if(goodS.equals(frontS)) return;			
		}
		
		//문자열의 길이가 N과 같아지면 강제종료 
				if(lv==N) {
					System.out.println(s);
					System.exit(0);
				}
		
		//여기 오는건 무조건 좋은 순열 , 왜냐하면 위쪽 for 문에서 안좋은건 return 되기때문
			for(int i = 1 ; i <= 3 ; i++ ) {
				DFS(lv+1,s+i);
			}
	}

}
