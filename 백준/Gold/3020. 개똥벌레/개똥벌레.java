import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		int N = read(); //길이
		int height = read(); //높이

		int suk[] = new int[height+2];
		int jon[] = new int[height+2];
		int sukSum = 0;
		int jonSum = 0;

		for(int i = 0 ; i < N ; i++){
			int tmp = read();
			if(i%2==0) {
				suk[tmp]++;
				sukSum++;
			}
			else {
				jon[tmp]++;
			}
		}

		int minV = Integer.MAX_VALUE;
		int minCnt = 0;

		for(int i = 1 ; i <= height ; i++){
			//i 높이에서 마주치는 게 몇개인지
			int sumOk = sukSum -= suk[i-1]; //높이 2일때 1은 안마주칠 것
			int jonOk = jonSum += jon[height-i+1]; // 높이 2일때 종유석높이 4이상은 마주칠 것

			int tmpminV = sumOk+jonOk;

			if(minV > tmpminV) {
				minV = tmpminV;
				minCnt = 0;
			}
			if(minV == tmpminV) minCnt++;
		}

		System.out.println(minV +" "+minCnt);
	}
	
	public static int read()throws Exception{
		int c,n = System.in.read() & 15;
		while((c = System.in.read()) > 32){
			n = (n<<3) + (n<<1) + (c&15);
		}
		return n;
	}
}
