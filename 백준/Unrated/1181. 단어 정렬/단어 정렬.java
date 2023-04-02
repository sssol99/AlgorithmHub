import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Comparator<String> comparator = (s1,s2)->{
			if(s1.length() == s2.length()) return s1.compareTo(s2);
			else return s1.length() - s2.length();
		};

		HashSet<String> set = new HashSet<String>();
		for(int i = 0 ; i < N ; i++){
			set.add(br.readLine());
		}

		Iterator<String> iter = set.iterator();
		N = set.size();
		ArrayList<String> arr = new ArrayList<>();
		while(iter.hasNext()){
			arr.add(iter.next());
		}

		Collections.sort(arr,comparator);

		StringBuilder sb = new StringBuilder();

		for(int i = 0 ; i < N ; i++){
			sb.append(arr.get(i)).append('\n');
		}
		System.out.println(sb);
	}
}

