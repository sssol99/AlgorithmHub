import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Node[] arr = new Node[N];

		for(int i = 0 ; i < N ; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end= Integer.parseInt(stk.nextToken());
			arr[i] = new Node(start,end);
		}

		Arrays.sort(arr);

		int cnt = 0;
		int end = 0;

		for(int i = 0 ; i < N ; i++){
			if(arr[i].start >=end){
				cnt++;
				end = arr[i].end;
			}
		}
		System.out.println(cnt);
	}

	static class Node implements Comparable<Node>{
		int start = 0;
		int end = 0;

		public Node(int start ,int end){
			this.start = start;
			this.end = end;

		}

		@Override
		public int compareTo( Node o2){
			if(this.end == o2.end){
				if(this.start < o2.start){
					return -1;
				}else return 1;
			}
			else{
				if(this.end>o2.end) return 1;
				else return -1;
			}
		}

	}
}

