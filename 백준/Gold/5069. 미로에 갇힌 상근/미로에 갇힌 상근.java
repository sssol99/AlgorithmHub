import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TK = Integer.parseInt(br.readLine());

		int[][][] s = new int [15][21][21];
		int dI[] = { 0,0,1,1,-1,-1 };
		int dJ[] = { 1,-1,1,0,-1,0 };

		s[0][10][10] = 1;

		for(int d = 1 ; d <15 ; d++){ //깊이
			for(int I = 1 ; I < 21 ; I++){ //I축
				for(int J = 1 ; J< 21 ; J++){ //J축
					for(int dir = 0 ; dir < 6 ; dir++){ //6각방향
						if(I + dI[dir] > 0 && I + dI[dir] < 21 && J + dJ[dir] > 0 && J + dJ[dir] < 21){ // 벗어나지 않는지 체크
							s[d][I][J] += s[d-1][I+dI[dir]][J+dJ[dir]];
						}
					}
				}
			}
		}

		StringBuilder sb= new StringBuilder();
		for(int i = 0 ; i<TK ; i++){
			int N = Integer.parseInt(br.readLine());
			sb.append(s[N][10][10]).append("\n");
		}

		System.out.println(sb);

	}
}
