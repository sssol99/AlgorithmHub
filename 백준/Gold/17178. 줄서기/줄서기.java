import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		N = Integer.parseInt(br.readLine()); // 줄 수
		Queue<Integer> randomZone = new LinkedList<>();
		arr = new int[N*5];

		int idx = 0;
		for(int i = 0 ; i < N ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 5 ; j++){

				String tmp = stk.nextToken().replace("-","");

				arr[idx] =	(int)tmp.charAt(0)*1000 + Integer.parseInt(tmp.substring(1));
				randomZone.add(arr[idx]);
				idx++;
			}
		}

		Arrays.sort(arr);

		System.out.println(consert(randomZone, new Stack<>()) ? "GOOD" : "BAD");


	}


	public static boolean consert(Queue<Integer> randomZone, Stack<Integer> waitingZone){
		//5명씩 끊어서 체크할 필요 x

		int idx = 0;
		//while문 안에서( 남은인원 끝)
		while(randomZone.size() >0){
			int peek = randomZone.peek();
			//정렬한 다음순서가 맞으면 pop
			if(peek == arr[idx]){
				randomZone.poll();
				idx++;
			}

			//다음순서보다 크거나 작으면 대기라인 체크 , 대기라인으로 넣기
			else{
				if(!waitingZone.isEmpty() && waitingZone.peek() == arr[idx]) {
					waitingZone.pop();
					idx++;
				}else{
					waitingZone.push(randomZone.poll());
				}
			}
		}

		//while문을 끝낸 다음 대기줄에 있는 걸 한번 확인해서 빼야하니까 체크
		int len = waitingZone.size();
		for(int i = 0 ; i < len ; i++){
			if(!waitingZone.isEmpty() && waitingZone.peek() == arr[idx]) {
				idx++;
				waitingZone.pop();
			}
		}

		//while 끝났을때 머가 남아있으면 return false
		if(waitingZone.size() !=0 ) return false;
		return true;
	}
}
