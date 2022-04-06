package dongbinbook.ch11_greedy_questions;

import java.util.Scanner;

public class Q2_MultiplyOrAdd {
    public static void main(String[] args) {
        Q2_MultiplyOrAdd ag = new Q2_MultiplyOrAdd();
        System.out.println(ag.solution());
    }
    public int solution() {
        Scanner sc = new Scanner(System.in);
        String[] ss  = sc.nextLine().split("");
        int result = 0;
        for( String s : ss) {
            int n = Integer.parseInt(s);
                if(result == 0 || n == 0 ) {
                    result += n;
                } else {
                    result *= n;
                }
        }
        return result;
    }
}

/*
02984
결과 576
567
결과 210
 */
