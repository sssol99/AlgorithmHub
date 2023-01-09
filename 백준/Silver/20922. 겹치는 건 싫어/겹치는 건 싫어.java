import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken()); // 정수 길이
		int K = Integer.parseInt(stk.nextToken()); // 겹치는 수열 길이

		int[] arr = new int[N]; // N수열 받을 배열
		int[] lap = new int[100001]; // 겹치는 수 체크할 배열

		int res = 0; // 정답

		int st = 0; // 시작 인덱스
		int ed = 0; // 끝 인덱스

		stk = new StringTokenizer(br.readLine());

		//arr 1부터 입력받기
		for(int i = 0 ; i <N ; i++){
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		while(ed < N ){

			if(lap[arr[ed]] != K){
				lap[arr[ed]]++;
				ed++;
			}else{
				res = Integer.max(res, ed-st);
				while(lap[arr[ed]] == K ){
					lap[arr[st]]--;
					st++;
				}
			}

		}

		res = Integer.max(res, ed-st);
		System.out.println(res);
	}
}
