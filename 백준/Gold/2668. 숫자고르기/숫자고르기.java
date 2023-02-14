import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	static boolean[] ck;
	static int[] arr;

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		ck = new boolean[N+1];

		for(int i = 1 ; i<= N ; i++){
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]==i) {
				ck[i] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for(int i = 1 ; i<= N ; i++){
			DFS(i,i,new boolean[N+1]);
		}

		int cnt = 0;
		for(int i = 1; i <=N ; i++){

			if(ck[i]) {
				sb.append(i).append('\n');
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println(sb);

	}

	public static void DFS(int start, int idx, boolean[] cyck){
		if(ck[idx]) return;
		if(cyck[idx]) return;
		cyck[idx] = true;
		if(arr[idx]==start){
			for(int i = 1; i <=N ; i++){
				if(cyck[i]) ck[i] = true;
			}
			return;
		}
		DFS(start,arr[idx],cyck);

	}
}
