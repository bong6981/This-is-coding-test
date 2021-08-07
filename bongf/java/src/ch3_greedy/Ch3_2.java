package ch3_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Ch3_2 {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
             l.add(sc.nextInt());
        }

        Collections.sort(l, Collections.reverseOrder());
        return (l.get(0) * 3 + l.get(1)) * (m /(k+1)) + l.get(0) * (m % (k+1));
    }
}
