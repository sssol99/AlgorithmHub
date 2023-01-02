import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 <제약 조건>
	 * 세로 N 가로 M의 바닥 높이가 주어짐
	 * 집터 맨 왼쪽 위의 좌표는 (0,0)
	 * 땅의 높이를 일정하게 바꾸어야 함
	 * 1. [1초] 좌표의 가장 위의 블록을 제거하여 인벤토리에 넣을 수 있음
	 * 2. [2초] 인벤토리에서 블록 하나를 꺼내 가장 위의 블록 위에 놓음
	 * 집터 아래에 빈 공간은 존재하지 않음
	 * 모든 블록은 같은 블록
	 * 작업을 시작할 때 인벤토리에 b개의 블록이 들어 있음
	 * 땅의 높이는 256블록을 초과할 수 없으며, 음수가 될 수 없음
	 
	 <입력 조건>
	 * 첫째 줄에 N(세로), M(가로), B(인벤토리에 든 블록 개수)
	 * 둘째 줄부터 N개의 줄에 M개의 정수로 땅의 높이가 주어진다
	 * 땅의 높이는 자연수이며, 256을 초과할 수 없다
	 
	 <풀이 방법>
	 * 인벤토리에서 블록 꺼내서 채우기 -> 2초
	 * 땅 파기 -> 1
	 * max 랑 min사이에서 모두 돌려보기
	 	* now (max와 min사이의 임의값)보다 큰것들 다 파서 + B 한 값이
	 	* 블록 채워야 할 수보다 크면 
	 	* 연산
	 	* else
	 	* continue;
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken()); // 세로
		int M = Integer.parseInt(stk.nextToken()); // 가로
		int B = Integer.parseInt(stk.nextToken()); //현재 블록 개수

		int[] arr = new int[N*M]; // 블록 담을 배열
		
		int max = Integer.MIN_VALUE; // 최대값 담을 변수
		int min = Integer.MAX_VALUE; // 최소값 담을 변수
		
		int time = Integer.MAX_VALUE; // 정답 - 시간 저장
		int high = 0; // 정답 - 높이 저장
		
		int idx = 0; 
		for(int i = 0 ; i < N ; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				arr[idx] = Integer.parseInt(stk.nextToken());
				max = Math.max(max, arr[idx]);
				min = Math.min(min, arr[idx]);
				idx++;
			}
		}
		
		//브루트포스
		for(int now = max ; now  >= min ; now--) {
			
			int block = B;
			
			int nowUp = 0; // 현재 값보다 큰 총합
			int nowDown = 0; // 현재 값보다 작은 총합
			
			//now 보다 큰 값들 다 찾기
			for(int i = 0 ; i < N*M ; i++) {
				if(arr[i] > now) nowUp+=(arr[i]-now);
			}
			
			//now 보다 작은 값들 다 찾기
			for(int i = 0 ; i < N*M ; i++) {
				if(arr[i] < now) nowDown+=(now-arr[i]);
			}
			
			//쌓을 수 있는 블록 개수 찾기
			block+= nowUp;
			
			if(nowDown != 0 & nowDown > block) continue;
			
	
			if(nowDown+nowUp*2 < time) {
				time = nowDown + nowUp*2;
				high = now;
			}	
		}
		
		System.out.println(time+" "+high);
	}

}
