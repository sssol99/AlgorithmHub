class Solution {
    public String solution(String new_id) {
        String answer = one(new_id);
        answer = two(answer);
        answer = three(answer);
        answer = four(answer);
        answer = five(answer);
        answer = six(answer);
        answer = seven(answer);
        return answer;
        
    }
    
    //소문자로 치환
    public String one(String new_id){
        return new_id.toLowerCase();
    }
    
    //소문자,숫자,빼기,밑줄,마침표 제외한 모든 문자 제거
    public String two(String new_id){
        String ret_id = "";
        for(int i = 0 ; i < new_id.length() ; i++){
            char now = new_id.charAt(i);
            if(now=='-' | now=='_' | now=='.' | (now >= 'a' & now <='z') | (now >= '0' & now <='9')){
                ret_id += now;
            }  
        }
        return ret_id;
    }
    
    public String three(String new_id){
        return new_id.replaceAll("[.]{2,}", ".");
    }
    
    public String four(String new_id){
        return new_id.replaceAll("^[.]|[.]$", "");
    }
    
      public String five(String new_id){
        if(new_id.equals("")){
            return "a";
        }
          return new_id;
    }
    
      public String six(String new_id){
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
        }
           new_id = new_id.replaceAll("[.]$", "");
          return new_id;
    }
           
    public String seven(String new_id){
        while(new_id.length()<3){
            new_id+=new_id.charAt(new_id.length()-1);
        }
        return new_id;
    }
}
         