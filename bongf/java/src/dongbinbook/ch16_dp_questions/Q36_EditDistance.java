package dongbinbook.ch16_dp_questions;

import java.util.Scanner;

public class Q36_EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = " " + sc.nextLine();
        String str2 = " " + sc.nextLine();

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (str2.charAt(i) == str1.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
