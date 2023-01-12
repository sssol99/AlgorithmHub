/*
<문제 분석>
*정렬되어있는 두 배열 A와 B가 주어진다
*두 배열을 합친 다음 정렬해서 출력하는 프로그램을 작성하시오

<입력>
* 첫째 줄 : 배열 A의 크기 N , 배열 B의 크기 M이 주어진다
* 둘째 줄 : 배열 A의 내용
* 셋째 줄 : 배열 B의 내용

<제한 사항>
배열에 들어있는 수는 절대값이 1000 000 000보다 작거나 같은 정수이다 -> int

<풀이 방법>
1. 각 배열에 startidx 를 0으로 놓는다
2. 두 값을 비교해서 차례대로 출력한다
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder res = new StringBuilder();

		int N = Integer.parseInt(stk.nextToken());  // 배열 A의 크기
		int M = Integer.parseInt(stk.nextToken()); // 배열 B의 크기

		int[] A = new int[N]; // 배열 A
		int[] B = new int[M]; // 배열 B

		int Aidx = 0;
		int Bidx = 0;

		stk = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < N ; i++){
			A[i] = Integer.parseInt(stk.nextToken());
		}

		stk = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < M ; i++){
			B[i] = Integer.parseInt(stk.nextToken());
		}

		while(Aidx < N & Bidx < M){
			//Aidx 배열값이 Bidx 배열값보다 작은 경우
			if(A[Aidx] < B[Bidx]){
				res.append(A[Aidx]+ " ");
				Aidx++;
			}else{
				res.append(B[Bidx] + " ");
				Bidx++;
			}
		}

		for(int i = Aidx ; i < N ; i ++){
			res.append(A[i]+ " ");
		}

		for(int i = Bidx ; i < M ; i ++){
			res.append(B[i] + " ");
		}

		System.out.println(res);
	}
}
