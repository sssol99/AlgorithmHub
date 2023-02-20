import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());

		Stack<Integer> high = new Stack<>();
		Stack<Integer> topIdx = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int arr[] = new int[N];

		for(int i = 0 ; i < N ; i++){
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		high.add(0);
		topIdx.add(0);


		for(int i = 0 ; i < N ; i++){
			//now가 stack peek보다 크면 0이 나오거나 now가 stackpeek보다 같거나 작을 때까지 pop
			while (arr[i] > high.peek() && high.peek() != 0){
				high.pop();
				topIdx.pop();
			}

			sb.append(topIdx.peek()).append(" ");
			high.add(arr[i]);
			topIdx.add(i+1);
			//인덱스를 sb에 추가
		}

		System.out.println(sb);
	}
}
