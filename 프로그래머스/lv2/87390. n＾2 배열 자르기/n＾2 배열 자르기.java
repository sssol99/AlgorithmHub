class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];

        long endI = right/n;
        long endJ = right%n;

        int idx = 0; 
        while(left <= right){
            
            int I = (int) (left/n);
            int J = (int) (left%n);
            
            int max = Integer.max(I,J)+1;
        
            answer[idx] = max;
            left++;
            idx++;
        }
        
        return answer;
    }
}