package ch11_greedy_questions;

import java.util.Scanner;

public class Q3_ReverseString {
    public static void main(String[] args) {
        Q3_ReverseString rs = new Q3_ReverseString();
        System.out.println(rs.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int z = 0;
        int o = 0;
        if(input.charAt(0) == '0') {
            z++;
        } else {
            o++;
        }

        for (int i = 0; i < input.length()-1; i++) {
             if(input.charAt(i) != input.charAt(i+1)) {
                 if(input.charAt(i+1) == '0') {
                     z++;
                 } else {
                     o++;
                 }
            }
        }
        return Math.min(z, o);
    }
}
