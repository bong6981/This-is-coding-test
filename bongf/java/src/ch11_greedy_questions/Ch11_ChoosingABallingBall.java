package ch11_greedy_questions;

import java.util.Scanner;

public class Ch11_ChoosingABallingBall {
    public static void main(String[] args) {
        Ch11_ChoosingABallingBall choosingABallingBall = new Ch11_ChoosingABallingBall();
        System.out.println(choosingABallingBall.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] weight = new int[m+1];
        for (int i = 0; i < n; i++) {
            int b = sc.nextInt();
            weight[b]++;
        }

        int answer = 0;
        for(int i=1; i<m; i++) {
            n -= weight[i];
            answer += weight[i] * n;
        }
        return answer;
    }
}

/*
5 3
1 3 2 3 2
## 8
 */

/*
8 5
1 5 4 3 2 4 5 2
## 25
 */
