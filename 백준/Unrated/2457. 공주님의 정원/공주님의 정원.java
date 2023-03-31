
import java.util.*;

public class Main {
	static class Flower implements Comparable<Flower> {
		int on;
		int off;

		public Flower(int on, int off) {
			this.on = on;
			this.off = off;
		}

		@Override
		public int compareTo(Flower o) {
			if(this.on == o.on) return o.off - this.off;
			else {
				return this.on-o.on;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		int N = read();
		ArrayList<Flower> flowers = new ArrayList<>(N);

		//입력받기
		for(int i = 0 ; i < N ; i++){
			int on =  read()*100 + read();
			int off = read()*100 + read();
			flowers.add(new Flower(on,off));
		}

		Collections.sort(flowers);

		int lastFlowerOff = 301; // 마지막 꽃이 지는 날짜
		int idx = 0; // 꽃이 피는 다음 것부터 탐색하기 위한 인덱스
		//최초에 시작할 꽃 찾기
		for(int i = 0 ; i < N ; i++){
			Flower flower = flowers.get(i);
			if(flower.on <= 301 & flower.off >= 301) {// 꽃이 지는 날짜가 3월 1일 이후이고, 꽃이 피는 날짜가 3월 1일 이전이면
				if(lastFlowerOff < flower.off){ // 저장한 마지막 꽃이 지는 날짜보다 꽃이 지는 날짜가 더 크면 갱신
					lastFlowerOff = flower.off;
					idx = i; // 현재 꽃 인덱스
				}
			}
		}

		if(idx==0 & flowers.get(0).on <= 301) lastFlowerOff = flowers.get(0).off;

		int cnt = 0; // 최소 꽃 개수
		//남은 꽃들 중 선택할거 정하기
		for(int i = idx ; i < N ; i++){
			Flower flower = flowers.get(i);
			cnt++;
			if(flower.off >= 1201) break;

			int maxFlowerOff = lastFlowerOff;
			int idx2 = i+1;
			for(int j =  i+1; j < N ; j++){
				Flower nextFlower = flowers.get(j);
				if(lastFlowerOff >= nextFlower.on){ // 이전에 꽃이 진 시간보다 지금 꽃이 핀 시간이 작거나 같아야함
					if(maxFlowerOff < nextFlower.off){ // 꽃이 지는 날짜가 더 커야 함
						maxFlowerOff = nextFlower.off; // 꽃이 지는 날짜를 더 긴 시간으로 갱신
						idx2 = j;
					}
				}else{ // 이전에 꽃이 진 시간보다 지금 꽃이 핀 시간이 크면 더이상 볼 필요 없음
					break;
				}
			}
			lastFlowerOff = maxFlowerOff;
			if(i+1!=idx2) {
				i = idx2-1;
			}

		}

		if(lastFlowerOff < 1201) System.out.println(0);
		else System.out.println(cnt);
	}


	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
