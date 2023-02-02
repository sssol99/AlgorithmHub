class Solution {
    public long solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        long sum = 0;
        
        int [] arr = new int[queue1.length*4];
        int idx = 0;
        
        for(int i = 0 ; i < queue1.length ; i++){
            sum+=queue1[i];
            arr[idx] = queue1[i];
            idx++;
        }
        for(int i = 0 ; i < queue2.length ; i++){
            sum+=queue2[i];
            arr[idx] = queue2[i];
            idx++;
        }
          
        for(int i = 0 ; i < queue1.length ; i++){
            arr[idx] = queue1[i];
            idx++;
        }
        for(int i = 0; i < queue2.length ; i++){
            arr[idx] = queue2[i];
            idx++;
        }
        
        
        //원형 큐에서 투포인터
        
        int start = 0;
        int end = (queue1.length)-1; //end 전까지 다 더하기
    
        if(sum %2 == 1) return -1;
        
        sum = sum/2;
        long cnt = 0;
        long qSum = 0;
        
        for(int i = 0 ; i < queue1.length ; i++){
            qSum+=arr[i];
        }
    

        while(start <=end){
          // System.out.println(start+" "+end+" qSum : "+qSum);
            if(qSum == sum) return cnt;
            
            else if(qSum < sum){
                if(end+1 >= arr.length) break;
                end++;
                qSum+=arr[end];
            }else{
                qSum-=arr[start];
                start++;
               
            }
              cnt++;
        }
        
        return -1;
    }
}