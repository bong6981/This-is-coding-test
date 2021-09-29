package ch12_implementation_qeustions;

import java.util.*;
import java.util.stream.Collectors;

public class Q8_StringResort {
    public static void main(String[] args) {
        Q8_StringResort sr = new Q8_StringResort();
//        System.out.println(sr.solution());
//        System.out.println(sr.dongbin());
    }

    public String solution() {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        List<Character> r = new ArrayList<>();
        int s = 0;
        int count = 0;
        for ( char c : chars) {
            if(  'A' <= c && c <= 'Z') {
                r.add(c);
            } else {
                s += Integer.parseInt(c+"");
                count++;
            }
        }

        Collections.sort(r);
        String collect = r.stream().map(String::valueOf).collect(Collectors.joining());
        return count == 0 ? collect : collect + String.valueOf(s);
    }

    // 애초에 배열을 안만들고 characterAt을 사용
    // Character.isLetter 메소드 사용
    public String dongbin() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<Character> result = new ArrayList<>();

        int value = 0;
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if(Character.isLetter(str.charAt(i))) {
                result.add(str.charAt(i));
            } else {
                value += str.charAt(i) - '0';
                count++;
            }
        }

        Collections.sort(result);
        String collect = result.stream().map(String::valueOf).collect(Collectors.joining());
        return count == 0 ? collect : collect + String.valueOf(value);
    }
}

/*
K1KA5CB7
결과 ABCKK13
AJKDLSI412K4JSJ9D
결과 ADDIJJJKKLSS20
 */
