package ch13_dfs_bfs_questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q19_InsertingOperators {
    public static int[] ints;
    public static int add;
    public static int sub;
    public static int mul;
    public static int div;
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        ints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        div = sc.nextInt();

        dfs(ints[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int result, int now) {
        if(now == n) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        if(add >0) {
            add--;
            dfs(result+ints[now], now+1);
            add++;
        }
        if(sub >0) {
            sub--;
            dfs(result-ints[now], now+1);
            sub++;
        }
        if(mul >0) {
            mul--;
            dfs(result * ints[now], now+1);
            mul++;
        }
        if(div >0) {
            div--;
            dfs(result / ints[now], now+1);
            div++;
        }

    }
}
