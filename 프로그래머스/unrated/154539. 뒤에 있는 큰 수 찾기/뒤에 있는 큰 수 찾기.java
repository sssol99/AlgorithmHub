import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[numbers.length];
        
        Arrays.fill(res,-1);
        //[0] : 현재값 [1] : idx
        for(int i = 0 ; i < numbers.length;  i++){
            //stack의 peek를 통해 내림차순인지 확인한다
            int[] tmp = {numbers[i],i};
            //스택이 비었으면 스택에 넣는다
            if(stack.isEmpty()) {
                stack.add(tmp);
            } else if(stack.peek()[0] < numbers[i]) {//스택이 차 있고 내림차순이 아니라면
                //내림차순이 될 때까지 반복한다
                while(!stack.isEmpty() && stack.peek()[0]<numbers[i]){
                    int[] stackTmp = stack.pop();
                    int idx = stackTmp[1];
                    res[idx] = numbers[i];
                }
            } 
            stack.add(tmp); 
        }
         return res; 
    }
}    