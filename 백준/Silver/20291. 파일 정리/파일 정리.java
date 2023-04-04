import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<String,Integer> map = new TreeMap<>();
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
		}
		for (Map.Entry<String,Integer> nowMap: map.entrySet()){
			String key = nowMap.getKey();
			String value = String.valueOf(nowMap.getValue());
			sb.append(key).append(" ").append(value).append("\n");
		}
		System.out.println(sb);
	}
}

