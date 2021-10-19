package ch14_sort_questions;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q26_SortingCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            pq.offer(x);
        }

        int answer = 0;
        while (pq.size() != 1) {
            int x = pq.poll();
            int y = pq.poll();
            answer += (x + y);
            pq.offer(x + y);
        }
        System.out.println(answer);
    }
}
