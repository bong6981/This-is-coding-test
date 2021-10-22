package ch15_binary_search_questions;

import java.util.Scanner;

public class Q28_FindFixedPoint {
    public static void main(String[] args) {
        Q28_FindFixedPoint ffp = new Q28_FindFixedPoint();
        System.out.println(ffp.solution());
    }

    private int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        return search(arr, 0, n-1);
    }

    private int search(int[]arr, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == mid) {
                return mid;
            }
            if(arr[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

/*
5
-15 -6 1 3 7
답  : 3
 */

/*
7
-15 -4 2 8 9 13 15
답  : 2
 */

/*
7
-15 -4 3 8 9 13 15
답  : -1
 */
