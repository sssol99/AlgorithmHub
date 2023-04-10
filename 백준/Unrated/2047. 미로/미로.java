import java.util.*;

import java.util.*;
import java.util.*;

public class Main {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			double ans = 0;
			String[] map = new String[100];
			boolean[][] vis = new boolean[100][100];
			int h = sc.nextInt();
			int w = sc.nextInt();
			for(int i = 0; i < h; i++) {
				map[i] = sc.next();
			}
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map[i].charAt(j) == 's') {
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {i, j});
						vis[i][j] = true;
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							for(int dir = 0; dir < 4; dir++) {
								int nx = dx[dir] + cur[0];
								int ny = dy[dir] + cur[1];
								if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
								if(map[nx].charAt(ny) == '#' || vis[nx][ny]) continue;
								ans++;
								q.offer(new int[] {nx, ny});
								vis[nx][ny] = true;
							}
						}
					}
				}
			}
			System.out.printf("%.2f\n", ans);
		}
		sc.close();
	}
}