package doit.ch06_sort;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] x = new int[]{1, 3, 6, 4, 7, 8, 9};
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    private static void bubbleSortImprovement1(int[] x, int length) {
        int exchanged = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = x.length - 1; j > i; j--) {
                if (x[j - 1] > x[j]) {
                    swap(x, j - 1, j);
                    exchanged++;
                }
            }
            if (exchanged == 0) {
                break;
            }
        }
    }

    private static void bubbleSortImprovement2(int[] x, int length) {
        int n = x.length;
        int k = 0;
        while( k < n-1) {
            int last = n-1;
            for (int j = x.length - 1; j > k; j--) {
                if (x[j - 1] > x[j]) {
                    swap(x, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }
}
