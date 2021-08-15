package ch4_implementation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ch4_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution()));
    }

    public static int[] solution() {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        sc.nextLine();
        String[] move = sc.nextLine().split(" ");

        Map<String, Integer> moveY = new HashMap<>();
        moveY.put("L", -1);
        moveY.put("R", 1);
        moveY.put("U", 0);
        moveY.put("D", 0);
        Map<String, Integer> moveX = new HashMap<>();
        moveX.put("L", 0);
        moveX.put("R", 0);
        moveX.put("U", -1);
        moveX.put("D", 1);

        int x = 1;
        int y = 1;
        for(String d : move) {
            int a = x + moveX.get(d);
            int b = y + moveY.get(d);
            if ( 1<=a && a<= s && 1<=b && b<=s) {
                x = a;
                y = b;
            }
        }
        return new int[]{x, y};
    }
}
