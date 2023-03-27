
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		int TK = read();
		StringBuilder sb = new StringBuilder();
		for(int t = 1 ; t <= TK ; t++){
			int tk = read();
			int cnt = 0;
			ArrayList<Integer> list = new ArrayList<>();
			list.add(read());
			for(int i = 1 ; i < 20 ; i++){
				int now = read();
				int idx = i;
				for(int j = i-1 ; j >= 0 ; j--){
					//앞에있는게 자신보다 작으면 cnt++;
					if(list.get(j) > now) cnt++;
					else break;
					idx = j;
				}
				list.add(idx,now);
			}
			sb.append(tk).append(" ").append(cnt).append('\n');
		}
		System.out.println(sb);
	}

	public static int read() throws Exception{
		int c,n = System.in.read() & 15;
		while((c = System.in.read()) > 32)
			n = (n<<3) + (n<<1) + (c&15);
		return n;
	}
}
