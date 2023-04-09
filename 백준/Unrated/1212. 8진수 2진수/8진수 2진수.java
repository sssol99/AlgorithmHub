

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		if(N.equals("0")) {
			System.out.println(0);
			System.exit(0);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N.length() ; i++){
			int tmp = N.charAt(i)-'0';


			StringBuilder binary = new StringBuilder();
			while(tmp > 0){
				binary.append(tmp%2);
				tmp/=2;
			}

			while(binary.length() <3){
				binary.append(0);
			}
			sb.append(binary.reverse());
		}

		int idx = 0;
		while(sb.charAt(idx) == '0'){
			idx++;
		}

		System.out.println(sb.substring(idx));

	}

}

