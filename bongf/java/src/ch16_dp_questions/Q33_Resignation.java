package ch16_dp_questions;

import java.util.Scanner;

public class Q33_Resignation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n+1];

        for(int i=0; i<n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            t[i] = x;
            p[i] = y;
        }

        int maxV = 0;
        for(int i=n-1; i>=0; i--) {
            int time = t[i] + i;
            if(time <= n) {
                dp[i] = Math.max(maxV, dp[time] + p[i]);
                maxV = dp[i];
                continue;
            }
            dp[i] = maxV;
        }
        System.out.println(maxV);
    }
}
