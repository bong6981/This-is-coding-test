package doit.ch06_sort;

public class InsertionSort {
    public static void main(String[] args) {

    }

    static void insertionSort(int[] arr, int n) {
        for (int i = 1; i <= n-1; i++) {
            int j;
            int temp = arr[i];
            for (j = i;  j > 0 && arr[j-1] > temp;) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
}
