import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * <문제설명>
 * 자연수 N과 M이 주어졌을 때, 
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른
 * 오름차순 순열을 출력하라
 * 
 * <조건>
 * 1<=M , <=N <=8)
 * 
 * <풀이방법>
 * M개를 뽑아서 오름차순으로 출력해야 하므로 현재 위치를 기억해줄 변수 하나를 뽑아서 그 변수부터 N개를 뽑는다.
 */

public class Main {
	static int M; // 고를 개수
	static int N; // 자연수 길이 (1~N)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken()); 
		M = Integer.parseInt(stk.nextToken());
		DFS(0,1,new boolean[N+1]);
	}

	public static void DFS(int lv, int start, boolean[] arr) {
		if(lv==M) {
			for(int i = 0 ; i < arr.length ; i++) {
				if(arr[i]) System.out.print(i+" ");		
			}
			System.out.println();
		}
		else {
			for(int i = start ; i <= N; i++) {
				arr[i] = true;
				DFS(lv+1,i+1, arr);
				arr[i] = false;
			}
		}
	}
}
