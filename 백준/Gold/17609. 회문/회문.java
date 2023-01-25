/*
<문제 분석>
회문 : 앞뒤 방향이 같은 문자열을
유사회문 : 한 문자를 삭제하여 회문으로 만들 수 있는 문자열

회문인지(0), 유사회문인지(1), 그것도 아닌지(2) 판단

<풀이방법>
1. 투포인터
	1-1. 양끝에 포인터 놓고, 서로 같은지 체크 / 만약 다르면 카운터. 카운터가 2이상이면 2출력
	<어떤 문자를 지울지>
		-> 서로 다른 경우가 나왔을 때,
			->왼쪽 지우고 체크
			->오른쪽 지우고 체크
	*실패 (왼쪽을 먼저 지웠는데 오답이고, 오른쪽이 정답인 경우 체크할 수 없음)

2. 재귀
	*성공 (분기를 나눌 수 있어서 성공)

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TK = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t = 0 ; t < TK ; t++){
			String s = br.readLine();
			res = Integer.MAX_VALUE;
			palindrome(0,s.length()-1,0,s);
			if(res>2) sb.append(2).append("\n");
			else sb.append(res).append("\n");
		}
		System.out.println(sb);
	}

	public static void palindrome(int l, int r, int cnt, String s){
		if(l>=r) {
			res = Integer.min(cnt,res);
			return;
		}

		if(s.charAt(l) == s.charAt(r)) palindrome(l+1, r-1, cnt, s);
		else{
			if(s.charAt(l+1) == s.charAt(r))palindrome(l+2,r-1,cnt+1,s);
			if(s.charAt(l) == s.charAt(r-1))palindrome(l+1,r-2,cnt+1,s);
		}
	}
}
