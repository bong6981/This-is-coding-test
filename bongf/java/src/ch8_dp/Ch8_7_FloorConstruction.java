package ch8_dp;

import java.util.Scanner;

public class Ch8_7_FloorConstruction {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i < n+1; i++) {
            d[n] = (d[i-1] + 2 * d[i-2] ) & 796796;

        }
        return d[n];
    }
}
/*
3
결과값 5
 */
