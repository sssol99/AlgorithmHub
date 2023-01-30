import java.util.*;

class Solution {
    
    static int[] dirI = {0,1,0,-1};
    static int[] dirJ = {1,0,-1,0};
    
    public int[] solution(int r, int c, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[r][c];
        for(int i = 0 ; i < r ; i++){
            for(int j = 0; j < c ; j++){
                arr[i][j] = (i*c+j)+1;
            }
        }
        
        //회전수만큼 반복
        for(int t = 0 ; t < queries.length; t++){
            int min = Integer.MAX_VALUE;
        
            int I1 = queries[t][0]-1; //x1
            int J1 = queries[t][1]-1; //y1
            int I2 = queries[t][2]-1; //x2
            int J2 = queries[t][3]-1; //y2
            
            Queue<Integer> q = new LinkedList<>();
            
            q.add(arr[I1][J1]);
                
            int nowI = I1+dirI[0]; 
            int nowJ = J1+dirJ[0];
            int dir = 0;
            
               if(nowI+1 < I1 | nowI+1 > I2 | nowJ < J1 | nowJ > J2) {// 다음값이 회전배열을 넘으면
                    dir++; // 방향 바꾸기
                    nowI = nowI+dirI[dir%4];
                    nowJ = nowJ+dirJ[dir%4];
                    //System.out.println("방향바꿈");
                }
           // System.out.println("start : "+nowI+" "+nowJ);
            
            int tmpdx = 0;
            while(true){
                tmpdx++;
                if(tmpdx > ((I2-I1) + (J2-J1)) *2 ) break;
                
                //System.out.println("nowI : "+nowI + " nowJ : "+nowJ);
                min = Integer.min(arr[nowI][nowJ],min);
                q.add(arr[nowI][nowJ]); // 자기꺼 큐에 저장
                arr[nowI][nowJ] = q.poll(); // 이전꺼 자기자리에 저장            
                
                int nextI = nowI+dirI[dir%4];
                int nextJ = nowJ+dirJ[dir%4];
          
                
                if(nextI < I1 | nextI > I2 | nextJ < J1 | nextJ > J2) {// 다음값이 회전배열을 넘으면
                    dir++; // 방향 바꾸기
                    nextI = nowI+dirI[dir%4];
                    nextJ = nowJ+dirJ[dir%4];
                    //System.out.println("방향바꿈");
                }
  
                //System.out.println("nextI : "+nextI + " nextJ : "+nextJ);
                nowI = nextI;
                nowJ = nextJ;
                
         /*
                for(int i = 0 ; i < r ; i++){
                    for(int j = 0; j < c ; j++){
                      System.out.print(arr[i][j]+ " ");
                    }
                System.out.println();
                }
                
                System.out.println();
*/
            }
            //System.out.println("1턴끝");
            answer[t] = min;
            
        }

        return answer;
    }

}