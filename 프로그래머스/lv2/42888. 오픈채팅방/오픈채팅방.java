import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    public ArrayList<String>  solution(String[] record) {
        
        ArrayList<String> answer = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();
		HashMap<String,String> map = new HashMap<String, String>();

		for(int i = 0 ; i < record.length ; i++){
			StringTokenizer stk = new StringTokenizer(record[i]," ");
			String state = stk.nextToken();
			String id = stk.nextToken();
			makeResult(state,id, result);

			if(stk.hasMoreElements()){
				String nickName = stk.nextToken();
				map.put(id,nickName);
			}
		}

		for(int i = 0 ; i < result.size() ; i++){
			String tmp = result.get(i);
			StringTokenizer stk = new StringTokenizer(tmp,"님");
			tmp = stk.nextToken();
			answer.add(result.get(i).replace(tmp,map.get(tmp)));
		}
        
        return answer;
    }
    
    	public void makeResult(String state, String id, ArrayList<String> result){
		StringBuilder sb = new StringBuilder();

		if(state.equals("Enter")){
			sb.append(id).append("님이 ").append("들어왔습니다.");
			result.add(sb.toString());
		}
		else if(state.equals("Leave")){
			sb.append(id).append("님이 ").append("나갔습니다.");
			result.add(sb.toString());
		}
	}
}