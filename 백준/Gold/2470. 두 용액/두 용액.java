/*
<문제 설명>
*산성 용액과 알칼리성 용액이 있다
*산성은 1부터 long 1 000 000 000 까지의 정수로 나타낸다
*알칼리성은 -1부터 long -1 000 000 000까지의 음의 정수로 나타낸다
*두 개의 용액을 합해서 특성값이 0에 가까운 용액을 만들려고 한다
*두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어 내라

<입력>
*N(전체 용액의 수) 2 <=2 <= 100 000
*용액들이 빈칸띄움으로 입력 -1 000 000 000 ~ 1 000 000 000 / 이들은 모두 다름
*산성이나 알칼리만으로 주어지는 경우도 존재함

<출력>
*특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다.
*가장 가까운 값이 2개 이상이면 아무거나 하나를 출력한다

<풀이 방법>
1. 정렬
2. 투포인터로 음수,양수를 체크해서 음수일땐 L을 , 양수일땐 R을 움직여서 모든 값을 체크함

 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 전체 용액의 수

		long[] arr = new long[N];

		StringTokenizer stk = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < N ; i ++){
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		int l = 0 ;
		int r = N-1;
		Long min = Long.MAX_VALUE; // 최소값을 갱신할 변수
		long minl = 0;
		long minr = 0;

		Arrays.sort(arr);

		while(l<r){

			if(Math.abs(arr[l] + arr[r]) < min){
				minl = arr[l];
				minr = arr[r];
				min = Math.abs(arr[l] + arr[r]);
			}

			if (arr[l] + arr[r] < 0){ // 현재 값이 음수면
				l++;

			}else if(arr[l] + arr[r] > 0){ //현재 값이 양수면
				r--;

			}else{ // 0이면
				break;
			}
		}
		System.out.println(minl+" "+minr);
	}
}
