import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String lazer = br.readLine();
		StringBuilder sb = new StringBuilder();

		Stack<int[]> stack = new Stack<>();
		StringTokenizer stk = new StringTokenizer(lazer);
		for(int i = 1 ; i <= N ; i++) {
			int top = Integer.parseInt(stk.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek()[1] > top) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if(stack.isEmpty()) sb.append(0).append(" ");
			int[] tmp = {i,top};
			stack.push(tmp);
		}

		System.out.println(sb);
	}
}