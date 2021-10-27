package ch16_dp_questions;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1932
public class Q32_IntegerTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Integer[] now = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
        Integer[] prev = now;

        for (int i = 1; i < n; i++) {
            now = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
            for (int j = 0; j < now.length; j++) {
                if (j == 0) {
                    now[j] = prev[0] + now[j];
                    continue;
                }
                if (j == now.length - 1) {
                    now[j] = prev[prev.length - 1] + now[j];
                    continue;
                }
                now[j] = Math.max(prev[j - 1], prev[j]) + now[j];
            }
            prev = now;
        }

        int ans = Arrays.stream(now).mapToInt(x -> x).max().getAsInt();
        System.out.println(ans);
    }
}
