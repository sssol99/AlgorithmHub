import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sTime1 = br.readLine();
		String sTime2 = br.readLine();

		int timeSec1 = changeSec(sTime1);
		int timeSec2 = changeSec(sTime2);

		if(timeSec2 < timeSec1 | timeSec1 == timeSec2) timeSec2 += 24*3600;

		System.out.println(changeTime(timeSec2-timeSec1));
	}

	public static int changeSec(String time){
		String[] arr = time.split(":");
		int sec = Integer.parseInt(arr[0])*3600 + Integer.parseInt(arr[1])*60 + Integer.parseInt(arr[2]);
		return sec;
	}

	public static String changeTime(int sec){
		String time = "";
		int tmp = (sec/3600);
		if(tmp < 10) time += "0" + tmp + ":";
		else time += tmp + ":";

		sec = sec%3600;

		tmp = sec/60;
		if(tmp < 10) time += "0" + tmp + ":";
		else time += tmp + ":";

		tmp = sec%60;
		if(tmp < 10) time += "0" + tmp;
		else time += tmp;

		return time;
	}
}
