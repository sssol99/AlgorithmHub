import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		TreeSet<Integer> A = new TreeSet<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++){
			A.add(Integer.parseInt(stk.nextToken()));
		}

		int arrA[] = new int[A.size()];
		int len = A.size();
		for(int i = 0 ; i < len; i++){
			arrA[i] = A.pollFirst();
		}

		int M = Integer.parseInt(br.readLine());

		stk = new StringTokenizer(br.readLine());

		for(int i = 0 ; i < M; i++){
			if(findNum(0,arrA.length-1, arrA,Integer.parseInt(stk.nextToken()))) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}

		System.out.println(sb);
	}

	private static boolean findNum(int l, int r, int[] arrA, int findNum) {


		while(l<=r){
			int mid = (l+r)/2;

			//배열값이 찾는수보다 크면 -> 줄여야함
			if(arrA[mid] > findNum){
				r = mid-1;
			}else if(arrA[mid] < findNum){
				l = mid+1;
			}else{
				return true;
			}
		}

		return false;
	}
}
