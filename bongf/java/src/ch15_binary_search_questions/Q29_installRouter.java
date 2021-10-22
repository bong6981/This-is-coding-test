package ch15_binary_search_questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q29_installRouter {
    public static void main(String[] args) {
        Q29_installRouter ir = new Q29_installRouter();
        System.out.println(ir.solution());
    }

    private int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int start = 1;
        int end = arr[n-1] - arr[0];
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 1;
            int prev = arr[0];
            for(int i =0; i<n; i++) {
                if(arr[i] - prev >= mid) {
                    cnt++;
                    prev = arr[i];
                }
            }
            if(cnt >= c) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid -1;
            }
        }
        return result;
    }
}
