/*
<문제 분석>
* (xyx)+() 는 괄호 내의 xyx의 반복으로 이루어진 전파의 집합을 뜻한다
* ex ) 10+ = 10, 100, 1000 ... / (1001)+ = 1001, 10011001, 100110011001
* (x)|(y) 는 x 또는 y를 의미하는 것이다
* ex ) 0+ | 1+ = 0,1,00,11,000,111 / (100 | 11) = 100, 11, 10011, 11100, 1110011100
* (100+1+ | 01)+ 의 패턴을 지니는 전파를 가려라

<입력>
*TK 길이
*전파를 표현하는 문자열이 공백 없이 주어짐
*문자열 길이는 1<=N<=200

<출력>
*해당 패턴을 지니면 YES
*해당 패턴을 지니지 않는다면 NO

<풀이방법>
*1로 시작할 때
->100(000)(111111) -> 한 뭉치
 *-> 1(0 0 : 최소 2개 이상 )1
 *1001/1001 -> 이 사이를 끊기 위해, 마지막 1은 자기 이후의 2,3자리가 0인지 확인해야 함

*0으로 시작할 때
->01이 맞는지
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TK = Integer.parseInt(br.readLine()); // 테스트 케이스의 수


        for (int i = 0; i < TK; i++) {
            String radio = br.readLine(); // 각 테스트 케이스의 전파

            if (findRadio(radio)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean findRadio(String radio) {
        int r = 0;

        while (r < radio.length()) {

            //1로 시작할 때
            if (radio.charAt(r) == '1') {
                r++;
                int cnt = 0;

                if (r >= radio.length()) return false;

                while (radio.charAt(r) == '0') {
                    r++;
					if (r >= radio.length()) return false;
                    cnt++;
                }
                if (cnt < 2) return false;

                if(radio.charAt(r)!='1') return false;
                while (radio.charAt(r) == '1') {
                    r++;
                    if( r < radio.length() & r+1  < radio.length() & r + 2 < radio.length()) {
                        if (radio.charAt(r)=='1' & radio.charAt(r+1) == '0' & radio.charAt(r + 2) == '0') break;
                    }

                    if (r >= radio.length()) break;

                }


                //0으로 시작할 때
            } else {
				if(r + 1 >= radio.length()) return false;
                if (radio.charAt(++r) != '1') return false;
				r++;
            }
        }
        return true;
    }
}
