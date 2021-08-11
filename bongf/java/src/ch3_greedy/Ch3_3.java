package ch3_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Ch3_3 {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            int min = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .min()
                    .orElse(answer);
            answer = Math.max(min, answer);
        }
        return answer;
    }
}
