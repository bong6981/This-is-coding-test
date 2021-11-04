package ch17_shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class Q38_ExactRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
           Arrays.fill(board[i], 501);
        }

        for (int i = 0; i < n+1; i++) {
            board[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            board[s][e] = 1;
        }

        // 주의. 초기값을 Integer.Max_Value로 했기 때문에 board[j][i] + board[i][k] 이렇게 하면 음수 나온다. int 범위 초과해서
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    board[j][k] = Math.min(board[j][i] + board[i][k], board[j][k]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if(board[i][j] != 501 || board[j][i] != 501) {
                    cnt++;
                }
            }
            if(cnt==n) {
                result++;
            }
        }
        System.out.println(result);
    }
}

/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
 */
