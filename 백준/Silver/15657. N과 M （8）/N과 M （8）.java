import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		//배열에 수열 받기 후 정렬하기
		N = Integer.parseInt(stk.nextToken()); //N개 자연수
		M = Integer.parseInt(stk.nextToken()); //골라야 할 수

		arr = new int[N];

		stk = new StringTokenizer(br.readLine());

		for(int i =0 ; i < N ; i++){
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(arr);
		//DFS로 중복순열 구하기
		DFS(0,"",0);
	}

	public static void DFS(int lv, String s, int idx){
		if(lv==M){
			System.out.println(s);
			return;
		}

		for(int i = idx; i < N ; i++){
			DFS(lv+1,s+arr[i]+" ", i);
		}
	}
}
