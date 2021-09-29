package ch12_implementation_qeustions;

import java.util.Scanner;

public class Q7_LuckyStraight {
    public static void main(String[] args) {
        Q7_LuckyStraight ls = new Q7_LuckyStraight();
//        System.out.println(ls.solution());
        System.out.println(ls.dongbin());
    }

    public String solution() {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split("");

        int sum = 0;
        for (int i = 0; i < (ss.length/2); i++) {
            sum += Integer.parseInt(ss[i]);
        }

        for (int i =(ss.length/2); i < ss.length; i++) {
            sum -= Integer.parseInt(ss[i]);
        }

        if(sum==0) {
            return "LUCKY";
        }
        return "READY";
    }

    // charAt 활용
    public String dongbin() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int sum = 0;
        for (int i = 0; i < (str.length()/2); i++) {
            sum += str.charAt(i) - '0';
        }

        for (int i =(str.length()/2); i <str.length(); i++) {
            sum -= str.charAt(i) - '0';
        }

        if(sum==0) {
            return "LUCKY";
        }
        return "READY";
    }
}

/*
123402
LUCKY
7755
READY
 */
