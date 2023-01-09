
/*
<문제 분석>
*N일
*X일 동안 연속적으로 가장 많이 들어온 방문자 수와 기간 출력

<입력>
* N 과 X가 첫 번째 줄에 주어진다
* 1일자부터 N일차까지 공백으로 주어진다

<출력>
* 첫째 줄에 X일동안 가장 많이 들어온 방문자 수를 출력한다
* 단, 최대 방문자 수가 0이라면 SAD를 출력한다
* 만약, 최대 방문자 수가 0이 아닌 경우 둘째 줄에 기간이 몇 개 있는지 출력한다.

<제약 사항>
1<= X <= N <= 250000
0<=방문자 수 <=8000

<풀이 방법>
8000제한인 방문자 수 배열을 만들어서 몇갠지 체크함
st, ed 로 x만큼을 계속 체크함
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken()); //지난 일수
		int X = Integer.parseInt(stk.nextToken()); // X일

		int[] arr = new int[N+1]; // 방문자 수 배열


		int st = 0; // start
		int ed = X-1; //end
		int visit = 0; // 방문자 수
		int maxvisit = 0; // 최대 방문자 수
		int maxVisitPeroidNum = 0; // 최대 방문 기간 개수 저장


		stk = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < N ; i++){
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		for(int i = 0 ; i < X ; i++){
			visit+=arr[i];
		}

		while(ed < N){
			//방문자 수가 더 크다면
			if(maxvisit < visit){
				//최대 방문 기간 개수 갱신
				maxvisit = visit;

				maxVisitPeroidNum = 1;
			//방문자 수가 최대 방문자 수와 같다면
			}else if(maxvisit == visit){
				//기간 늘리기
				maxVisitPeroidNum++;
			}

			visit-=arr[st];

			ed++;

			visit+=arr[ed];

			st++;
		}

		if(maxvisit == 0){
			System.out.println("SAD");
		}else{
			System.out.println(maxvisit);
			System.out.println(maxVisitPeroidNum);

		}

	}
}
