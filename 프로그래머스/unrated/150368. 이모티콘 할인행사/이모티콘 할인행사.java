/*
이모티콘 플러스 가입자를 늘리고 이모티콘 판매액을 늘려라
n명에게 m개를 할인하여 판매한다(10% 20% 30% 40%)
-이모티몬 구매 비용이 일정 가격 이상이면 구매를 취소하고 플러스 가입함
*/

class Solution {
    static int m; //이모티콘 개수
    static int plusCntRes = 0;
    static int moneySumRes = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] ratio = {10,20,30,40};
        m = emoticons.length;
        //중복순열로 구한 다음에 가장 많은 플러스, 가장 많은 금액을 return
        DFS(0,new int[m], ratio, users, emoticons);
        int[] answer = {plusCntRes,moneySumRes};
        return answer;
    }
    
    public void DFS(int lv, int[] ck, int[] ratio,int[][] users, int[] emoticons){ //10,20,30,40
        if(lv==m){
          
            int plusCnt = 0; // 모든 이용자의 이모티콘 플러스 가입 여부
            int moneySum = 0; // 모든 이용자의 돈합
            
            //모든 이용자 체크
            for(int i = 0 ; i < users.length; i++){
                 int userMoneySum = 0; // 현재 유저의 돈합
                 for(int j = 0 ; j < m ; j++) {       
                     //이모티콘을 구매하는 경우
                 if(users[i][0] <= ratio[ck[j]]){ 
                     userMoneySum += emoticons[j]*((100-ratio[ck[j]])/100.0);
                 }
                    
                }
                //이모티콘 플러스로 넘어갈 경우                    
                 if(userMoneySum >= users[i][1]) {
                     plusCnt++; //현재 페이즈의 가입수 하나 늘리기
                     userMoneySum = 0; // 사용한 돈 0으로 바꾸기
                    }
                moneySum += userMoneySum; // 모든 유저 돈에 현재 유저 돈합 갱신
            }
    
            //출력값 갱신
            if(plusCntRes < plusCnt){  // 정답 플러스 개수보다 현재 페이즈가 더 크면
                plusCntRes = plusCnt; //정답 플러스개수 갱신
                moneySumRes = moneySum; // 정답 가격 갱신
            }else if(plusCntRes == plusCnt){ //정답 플러스 개수와 현재 페이즈가 같으면
                moneySumRes = Integer.max(moneySumRes, moneySum); //정답가격 갱신
            }
          
            return;
        }
        
        for(int i = 0 ; i < 4 ; i++){
            ck[lv] = i;
            DFS(lv+1, ck,ratio,users,emoticons);
        }
        
    }
     
}