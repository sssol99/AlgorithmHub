import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] arr;
	static int N;
	static int M;
	static int ck[];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		arr = new int[N];

		stk = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++){
			arr[i] = (Integer.parseInt(stk.nextToken()));
		}
		Arrays.sort(arr);
		ck = new int[N+1];

		DFS(0,new boolean[N],"");
	}

	public static void DFS(int lv, boolean ck[],String s){
		if(lv == M){
			System.out.println(s);
			return;
		}

		int before = -1;
		for(int i = 0 ; i < N ; i++){
			if(before==arr[i]) continue;
			if(ck[i]) continue;

			ck[i] = true;
			DFS(lv+1, ck,s+arr[i]+" ");
			ck[i] = false;

			before = arr[i];
		}
	}
}
