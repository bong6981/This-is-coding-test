package ch16_dp_questions;

import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] board = new int[n][m];
            for (int j = 0; j < n * m; j++) {
                int x = j / m;
                int y = j % m;
                int v = sc.nextInt();
                board[x][y] = v;
            }


            for (int j = 1; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int y = j - 1;
                    int v = board[k][j];
                    for (int z = k - 1; z <= k + 1; z++) {
                        if (0 <= z && z < n) {
                            v = Math.max(v, board[k][j] + board[z][y]);
                        }
                    }
                    board[k][j] = v;
                }
            }

            int ans = 0;
            for (int a = 0; a < n; a++) {
                ans = Math.max(board[a][m - 1], ans);
            }
            System.out.println(ans);
        }
    }
}

/*
1
3 4
1 3 3 2 2 1 4 1 0 6 4 7
---
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
 */
