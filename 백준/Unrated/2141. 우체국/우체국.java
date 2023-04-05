
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	static class Node implements Comparable<Node>{
		long village; // 마을 넘버
		long pCnt; // 사람 수

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.village,o.village);
		}

		public Node(long village, long pCnt) {
			this.village = village + 1_000_000_000;
			this.pCnt = pCnt;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<Node> nodes = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			nodes.add(new Node(Integer.parseInt(stk.nextToken()),Integer.parseInt(stk.nextToken())));
		}

		//알고리즘 사용변수 초기화

		BigInteger sumR = BigInteger.valueOf(0L); // 오른쪽 계산값
		BigInteger sumL = BigInteger.valueOf(0L); // 왼쪽 계산값
		BigInteger sumRM = BigInteger.valueOf(0L); // 오른쪽에서 뺄 계산값
		BigInteger sumLM = BigInteger.valueOf(0L); // 왼쪽에서 더할 계산값
		BigInteger tmp = BigInteger.valueOf(1000000000000000000L);
		BigInteger res = tmp.multiply(tmp.multiply(tmp.multiply(tmp.multiply(tmp))));
		BigInteger idxRes = BigInteger.valueOf(0L);

		Collections.sort(nodes);

		//알고리즘 시작!
		for (int i = 1; i < N; i++) {
			BigInteger pCnt = BigInteger.valueOf(nodes.get(i).pCnt);
			BigInteger nextVilNum = BigInteger.valueOf(nodes.get(i).village);
			BigInteger firstVilNum = BigInteger.valueOf(nodes.get(0).village);

			sumR = sumR.add(pCnt.multiply(nextVilNum.subtract(firstVilNum)));
			sumRM = sumRM.add(pCnt);
		}

		for (int i = 0; i < N - 1; i++) {
			BigInteger nextVilNum = BigInteger.valueOf(nodes.get(i+1).village);
			BigInteger nowVilNum = BigInteger.valueOf(nodes.get(i).village);
			BigInteger nextCnt = BigInteger.valueOf(nodes.get(i+1).pCnt);
			BigInteger nowCnt = BigInteger.valueOf(nodes.get(i).pCnt);

			// 오른쪽 계산값과 왼쪽 계산값 합해서 res 비교
			BigInteger sum = sumR.add(sumL);
			if (res.compareTo(sum) > 0) {
				res = sum; // 거리대비인구 합 갱신
				idxRes = nowVilNum; // 위치 갱신
			}

			// 오른쪽 계산값 갱신
			sumR = sumR.subtract(sumRM.multiply(nextVilNum.subtract(nowVilNum)));
			sumRM = sumRM.subtract(nextCnt);

			// 왼쪽 계산값 갱신
			sumLM = sumLM.add(nowCnt);
			sumL = sumL.add(sumLM.multiply(nextVilNum.subtract(nowVilNum)));
		}

// 마지막 인덱스
		if (res.compareTo(sumL) > 0) {
			idxRes = BigInteger.valueOf(nodes.get(N- 1).village); // 위치 갱신
		}

		System.out.println(idxRes.subtract(BigInteger.valueOf(1_000_000_000)).intValue());
	}
}

