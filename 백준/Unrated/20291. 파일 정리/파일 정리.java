
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arr = new ArrayList<>();
		Map<String,Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for(int i = 0 ; i < N ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine(),".");
			String name = stk.nextToken();
			String ex = stk.nextToken();

			if(map.containsKey(ex)){ // 이미 값이 있으면
				map.put(ex,map.get(ex)+1);
			}else{ //값이 없으면
				map.put(ex,1);
			}

			arr.add(ex);
		}

		Collections.sort(arr);

		String before = "";
		for(int i = 0 ; i < arr.size() ; i++){
			String now = arr.get(i);
			if(!before.equals(now)) {
				sb.append(now).append(" ").append(map.get(now)).append("\n");
				before = now;
			}
		}

		System.out.println(sb);
	}
}

