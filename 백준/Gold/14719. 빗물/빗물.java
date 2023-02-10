import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		stk.nextToken();

		int[] block = new int[Integer.parseInt(stk.nextToken())];

		stk = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < block.length ; i++){
			block[i] = Integer.parseInt(stk.nextToken());
		}

		int res = 0;
		int start = block[0];
		int idx = 0;

		for(int i = 0 ; i < block.length ; i++){
			int blocksum = 0;
			for(int j = i+1 ; j < block.length; j++){
				//현재 블록보다 큰 블록을 만나면
				if(start <= block[j]){
					res += (j-i-1)*start-blocksum;
					i = j-1; // 다음 for문에서 ++되므로
					start = block[j];
					idx = j;
					break;
				}
				blocksum+=block[j];
			}
		}

		start = block[block.length-1];

		for(int i = block.length-1 ; i>=idx ; i--){
			int blocksum = 0;
			for(int j = i-1; j >= idx ; j-- ){
				if(start <= block[j]){
					res += (i-j-1)*start-blocksum;
					i = j+1; // 다음 for문에서 ++되므로
					start = block[j];
					break;
				}
				blocksum+=block[j];
			}
		}
		System.out.println(res);
	}
}
