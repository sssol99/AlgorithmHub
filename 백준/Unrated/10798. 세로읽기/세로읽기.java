import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		char[][] arr = new char[5][15];
		for(int i = 0 ; i < 5 ; i++){
			String tmp = br.readLine();
			for(int j = 0 ; j < tmp.length() ; j++){
				arr[i][j] = tmp.charAt(j);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 15 ; i++){
			for(int j = 0 ; j < 5 ; j++){
				if((arr[j][i] >= '0' & arr[j][i] <='9' ) | (arr[j][i] >='A' & arr[j][i] <='z')) sb.append(arr[j][i]);
			}
		}

		System.out.println(sb);
	}
}
