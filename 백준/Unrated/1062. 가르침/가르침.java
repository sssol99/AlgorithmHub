import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static String[] arr;
	static int maxRes = 0;
	//static Iterator<String> iter;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken()); // 단어의 개수
		K = Integer.parseInt(stk.nextToken()); //배울 수 있는 단어의 개수
		arr = new String[N];
		for(int i = 0 ; i < N ; i++){
			String tmp = br.readLine();
			tmp = tmp.replaceAll("a|n|t|i|c","");
			arr[i] = tmp;
		}
		if(K < 5) System.out.println(0);
		else{
			DFS(0,new boolean[26],0);
			System.out.println(maxRes);
		}

	}

	public static void DFS(int lv, boolean[] ck, int idx){
		if(lv>=K-5){
			int res = 0;
			for(int i = 0 ; i < N ; i ++){
				int cnt = 0;
				for(int j = 0 ; j < arr[i].length() ; j++){
					if(ck[arr[i].charAt(j)-'a']) cnt++;
				}
				if(cnt==arr[i].length()) res++;
			}

			maxRes = Integer.max(res,maxRes);
			return;
		}

		for(int i = idx ; i < 26 ; i++){
			if(i=='a'-'a' |i=='n'-'a'| i=='t'-'a'| i=='i'-'a'| i=='c'-'a' ) continue;
			ck[i] = true;
			DFS(lv+1,ck,i+1);
			ck[i] = false;
		}


	}
}

