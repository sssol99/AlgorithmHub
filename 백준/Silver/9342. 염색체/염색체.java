
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Pattern pattern = Pattern.compile("^(A*|B*|C*|D*|E*|F*)A+F+C+(A*|B*|C*|D*|E*|F*)$");

		for(int i = 0 ; i < T ; i++){

			String nowString = br.readLine();
			Matcher matcher = pattern.matcher(nowString);
			if(matcher.matches()) System.out.println("Infected!");
			else System.out.println("Good");
		}
	}
}
