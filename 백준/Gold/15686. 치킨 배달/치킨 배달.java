import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1. 없앨 치킨집을 구한 후, 남은 치킨집에서 최소 거리를 구한다

 */

public class Main {

	static int N; // 도시 크기
	static int M; // 골라야 하는 치킨집 개수

	static ArrayList<int[]> chicks;

	static ArrayList<int[]> houses;

	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		min = Integer.MAX_VALUE;

		chicks = new ArrayList<>();
		houses = new ArrayList<>();

		for(int i = 0 ; i < N ; i++){
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j  <N ; j++){
				int now = Integer.parseInt(stk.nextToken());
				int[] tmp = {i,j};
				if(now == 1) houses.add(tmp);
				else if(now==2) chicks.add(tmp);

			}
		}

		findChick(0, new boolean[chicks.size()], 0);
		System.out.println(min);
	}

	public static void findChick(int lv, boolean[] ck ,int idx){
		if(lv==M){
			min = Integer.min(findMinD(ck), min);
			return;
		}

		for(int i = idx ; i < chicks.size() ; i++){
			ck[i] = true;
			findChick(lv+1, ck, idx = i+1);
			ck[i] = false;
		}
	}

	private static int findMinD(boolean[] ck) {

		int res = 0;
		for(int i = 0 ; i < houses.size() ; i++){
			int min = Integer.MAX_VALUE;
			for(int j = 0 ; j < chicks.size() ; j++){
				if(!ck[j]) continue;
				min = Integer.min(min,Math.abs(chicks.get(j)[0]-houses.get(i)[0])+ Math.abs(chicks.get(j)[1] - houses.get(i)[1]));
			}
			res+=min;
		}
		return res;
	}
}
