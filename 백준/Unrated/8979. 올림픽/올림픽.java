
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static class Grade implements Comparable<Grade>{
		int id;
		int gold;
		int silver;
		int bronze;

		public Grade(int id, int gold, int silver, int bronze) {
			this.id = id;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}

		@Override
		public int compareTo(Grade o) {
			if(this.gold == o.gold){
				if(this.silver == o.silver){
					return o.bronze - this.bronze;
				}else{
					return o.silver - this.silver;
				}
			}else{
				return o.gold-this.gold;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		int N = read(); // 국가의 수
		int K = read(); // 등수를 알고 싶은 국가

		ArrayList<Grade> arr = new ArrayList<>();
		for(int i = 0 ; i < N ; i ++){
			arr.add(new Grade(read(),read(),read(),read()));
		}

		Collections.sort(arr);

		Grade grade = arr.get(0);
		int cnt = 1;
		if(grade.id == K) System.out.println(cnt);
		else{
			for(int i = 1 ; i < N ; i ++){
				Grade nowGrade = arr.get(i);
				cnt++;
				if(grade.gold == nowGrade.gold & grade.silver == nowGrade.silver & grade.bronze == nowGrade.bronze) cnt--;
				if(nowGrade.id == K) {
					System.out.println(cnt);
					break;
				}

				grade = nowGrade;
			}
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
