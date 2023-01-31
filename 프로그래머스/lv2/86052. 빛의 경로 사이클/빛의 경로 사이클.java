import java.util.*;

class Solution {
    
    boolean[][][] isVisited;
    int lenI;
    int lenJ;
    int[] dI = {-1,0,1,0}; // 위 오 아래 왼
    int[] dJ = {0,1,0,-1};

    public ArrayList<Integer> solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        lenI = grid.length;
        lenJ = grid[0].length();
        
        isVisited = new boolean[lenI][lenJ][4];
        
        for(int i = 0 ; i < lenI ; i++){
            for(int j = 0 ; j < lenJ ; j++){
                for(int d = 0 ; d < 4 ; d++){
                    if(!isVisited[i][j][d]) {
                        int tmpcnt = checkLen(grid,i,j,d);
                        if(tmpcnt!=0) answer.add(tmpcnt);
                    }
                }
            }
        }
        Collections.sort(answer);
           return answer;
    }
    
    //이동거리를 체크하는 메소드
    public int checkLen(String grid[], int I, int J, int d){
        int len = 0;
        
        while(true){
            if(isVisited[I][J][d]) break;
      
        
        len++;
        isVisited[I][J][d] = true;
        
        if(grid[I].charAt(J) == 'L'){
                if(d==0) d = 3;
                else d = d-1;
            }
           
        else if(grid[I].charAt(J) == 'R'){
                if(d==3) d = 0;
                else d = d+1;
            }
            
        I = (I+dI[d] + lenI) % lenI;
        J = (J+dJ[d] + lenJ) % lenJ;
          }
        
        return len;
    }
}