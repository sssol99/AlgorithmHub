
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		String S = br.readLine();
		for(int i = 0 ; i < S.length() ; i++){

			if(S.charAt(i) == '<'){
				while(i < S.length() && S.charAt(i)!='>'){
					sb.append(S.charAt(i));
					i++;
				}
				sb.append('>');
			}else if(S.charAt(i)==' ') {
				sb.append(' ');
			}
			else{
				while(i < S.length() && S.charAt(i) != ' ' && S.charAt(i)!='<'){
					stack.add(S.charAt(i));
					i++;
				}

				while(!stack.isEmpty()){
					sb.append(stack.pop());
				}
				i--;
			}
		}
		System.out.println(sb);
	}
}

