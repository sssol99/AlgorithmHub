import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;

	static ArrayList<Integer> crains = new ArrayList<>();
	static ArrayList<Integer> boxes =  new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i ++) crains.add(Integer.parseInt(stk.nextToken()));

		M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < M ; i ++) boxes.add(Integer.parseInt(stk.nextToken()));

		Collections.sort(crains);
		Collections.sort(boxes);

		int res = 0;
		if(boxes.get(boxes.size()-1) > crains.get(crains.size()-1)) {
			System.out.println(-1);
			System.exit(0);
		}

		while(!boxes.isEmpty()){
			res++;
			for(int i =  0; i <N ; i++){
				// boxesN-1 에서 이분탐색으로 뺄 수 있는 인덱스 찾기
				if(binarySearch(crains.get(i)));
			}
		}
		System.out.println(res);

	}

	public static boolean binarySearch(int maxW){
		int l = 0 ;
		int r = boxes.size()-1;
		int m = -1;

		while(l<=r){
			m = (l+r)/2;

			//만약에 박스무게가 크레인 무게보다 크다면 -> 박스무게를 줄여야 함
			if(boxes.get(m) > maxW){
				r = m-1;
			}//만약에 박스무게가 크레인 무게보다 작거나 같다면 -> 박스무게를 늘려야 함
			else {
				l = m+1;
			}
		}

		if(m==-1 || boxes.get(m) > maxW) {

				for(int i = m ; i >=0 ; i--){
					if(maxW >= boxes.get(i)) {
						boxes.remove(i);
						return true;
					}
				}
				return false;
		}
		else {
			boxes.remove(m);
			return true;
		}
	}
}
