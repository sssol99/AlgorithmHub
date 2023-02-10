import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int C;
	static int[] arr;
	static int res = 1;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		 C = Integer.parseInt(stk.nextToken());
		 arr = new int[N];
		
		 for(int i = 0 ; i < N ; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		 }
		 Arrays.sort(arr);
		 
		 int L = 1; // 최소 공유기 사이 거리
		 int R = arr[N-1];
		 
		 while(L<=R) {
			 int mid = (L+R)/2;
			 if(C>count(mid)) {// 공유기 수가 원하는것보다 작을 때 -> 간격을 줄여야함(최대거리가 줄어듬)
				 R = mid-1;
			 }else { // 공유기 수가 원하는것보다 많을 때 -> 간격을 늘려야함 (최대거리가 늘어남)
				 L = mid+1;
				 res = Integer.max(mid, res);
			 }
		 }
		 System.out.println(res);

	}

	private static int count(int dir) {
		int now = arr[0];
		int cnt = 1;
		for(int i = 1 ; i < N ; i++) {
			if(arr[i]-now >= dir) {
				now = arr[i];
				cnt++;
			}
		}
		return cnt;
	}

}
