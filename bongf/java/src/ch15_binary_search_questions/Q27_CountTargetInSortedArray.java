package ch15_binary_search_questions;

import java.util.Scanner;

public class Q27_CountTargetInSortedArray {
    public static void main(String[] args) {
//        dongbin();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int index = binarySearch(arr, 0, n-1, x);
        if(index== -1) {
            System.out.println(-1);
            return;
        }

        int newIndx = index;
        for(int i = index; i>=0; i--) {
            if(arr[i] != x) {
                break;
            }
            newIndx = i;
        }

        int cnt = 0;
        for(int i=newIndx; i<n; i++) {
            if(arr[i] != x) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = (start+end) /2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] > target) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void dongbin() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = countByRange(arr, x, x);
        if(cnt == 0) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }

    }

    private static int countByRange(int[] arr, int leftValue, int rightValue) {
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);
        System.out.println(rightIndex + "," + leftIndex);
        return rightIndex - leftIndex;
    }

    private static int lowerBound(int[] arr, int target, int start, int end) {
        while(start<end) {
            int mid = (start + end) / 2;
            if(arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private static int upperBound(int[] arr, int target, int start, int end) {
        while( start < end ) {
            int mid = (start + end) /2;
            if (arr[mid] > target) end = mid;
            else start = mid +1;
        }
        return end;
    }

}

/*
 7 2
 1 1 2 2 2 2 3
 */

/*
 7 4
 1 1 2 2 2 2 3
 */
