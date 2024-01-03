import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int sum = 0;
        
        for(int i = 0 ; i < 5 ; i++){
            int tmp = Integer.parseInt(stk.nextToken());
            sum += tmp*tmp;
        }
        System.out.println(sum%10);
    }
}