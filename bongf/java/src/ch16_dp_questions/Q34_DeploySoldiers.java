package ch16_dp_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q34_DeploySoldiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] soldiers = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxV = 1;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            soldiers[i] = x;
            for(int j=i-1; j >=0; j--) {
                if(soldiers[j] > x) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxV = Math.max(maxV, dp[i]);
                }
            }
        }
        System.out.println(n - maxV);
    }

    public static void dongbin(String[] args) {
        int n;
        ArrayList<Integer> v = new ArrayList<Integer>();
        int[] dp = new int[2000];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            v.add(sc.nextInt());
        }

        // 순서를 뒤집어 '최장 증가 부분 수열' 문제로 변환
        Collections.reverse(v);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (v.get(j) < v.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        System.out.println(n - maxValue);
    }
}
