package dongbinbook.ch14_sort_questions;

import java.util.*;

// https://www.acmicpc.net/problem/18310
public class Q24_Antenna {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] homes = new int[n];

        for (int i = 0; i < n; i++) {
            homes[i] = (sc.nextInt());
        }
        Arrays.sort(homes);
        System.out.println(homes[(int) (n-1) / 2]);
    }


    //시간초과
    public static void fail(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] homes = new int[n];

        for (int i = 0; i < n; i++) {
            homes[i] = (sc.nextInt());
        }
        List<Integer> answers = new ArrayList<>();
        long distance = Long.MAX_VALUE;


        for (int i = 1; i <= 100000; i++) {
            int result = 0;
            for (Integer h : homes) {
                result += Math.abs(h - i);
            }
            if (distance == result) {
                answers.add(i);
            } else {
                if (result < distance) {
                    distance = result;
                    answers = new ArrayList<>();
                    answers.add(i);
                }
            }
        }
        Collections.sort(answers);
        System.out.println(answers.get(0));
    }
}
