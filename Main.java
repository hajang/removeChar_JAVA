//
// Created by Ha on 16. 1. 2..
//

/*
   page 180
   문자열에서 문자를 효율적으로 삭제하는 함수를 작성하라 함수 원형은 다음과 같다.
   String removeChars(String str, String remove);

   remove라는 인자로 전달된 문자열에 있는 모든 문자를 str이라는 문자열에서 삭제한다.
   예를 들어, str이 "Battle of the Vowels: Hawaii vs. Grozny"로 주어지고 remove가
   "aeiou"로 주어진다며 이 함수에서 str을 "Bttl f th Vwls: Hwi vs. Grzny"로 변환시켜야 한다.
 */


public class Main {

    public static void main(String[] args) {
        String s = removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou");
        print(s);

    }

    public static String removeChars(String str, String remove){

        // 문자열 modification을 위한 stringbuilder
        StringBuilder sb = new StringBuilder(str);

        // flags of ascii code 0 - 127
        boolean flags[] = new boolean[128];

        // remove 문자열에 존재하는 문자들의 flag를 set
        for(int i = 0; i < remove.length(); i++)
            flags[remove.charAt(i)] = true;

        // str 문자열을 처음부터 종주하며 src로 부터 dst로 문자 복사
        int src = 0, dst = 0;
        for(; src < str.length(); src++){

            // 만약 중간에 flag가 set되어 있는 문자가 있다면 스킵하고 다음 문자부터 진행
            if(flags[str.charAt(src)])
                src++;

            sb.setCharAt(dst++, sb.charAt(src));
        }

        // 결과는 str문자열 시작부터 dst위치까지
        String result = sb.toString();
        return result.substring(0, dst);
    }

    public static void print(String s){
        System.out.println(s);
    }
}