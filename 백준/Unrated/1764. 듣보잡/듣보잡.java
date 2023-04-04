
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken()); // 듣도못한사람의수
		int M = Integer.parseInt(stk.nextToken()); // 보도못한사람의수
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		ArrayList<String> arr = new ArrayList<>();

		Set<String> set = new HashSet<>();

		for(int i = 0 ; i < N ; i++){
			set.add(br.readLine());
		}

		for(int i = 0 ; i < M ; i++){
			String now  = br.readLine();
			if(set.contains(now)){
				arr.add(now);
				cnt++;
			}
		}

		Collections.sort(arr);
		sb.append(cnt).append('\n');
		for(int i = 0 ; i < arr.size() ; i++){
			sb.append(arr.get(i)).append('\n');
		}

		System.out.println(sb);
	}
}

