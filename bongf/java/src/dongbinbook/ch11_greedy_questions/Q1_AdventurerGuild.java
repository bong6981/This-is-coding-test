package dongbinbook.ch11_greedy_questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_AdventurerGuild {
    public static void main(String[] args) {
        Q1_AdventurerGuild ag = new Q1_AdventurerGuild();
        System.out.println(ag.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        int result = 0;
        int count = 0;
        for(int d : data) {
            count++;
            if( count >= d) {
                result++;
                count = 0;
            }
        }
        return result;
    }
}

/*
5
2 3 1 2 2
결과 2
 */
