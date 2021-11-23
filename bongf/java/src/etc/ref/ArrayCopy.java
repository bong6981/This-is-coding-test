package etc.ref;

import java.util.Arrays;

// 주의 이건 다 shallow copy, 근데 아래 예시는 primitive라 괜찮
public class ArrayCopy {
    public static void main(String[] args) {
//        useSystemClass();
        useArraysClass2();
    }

    private static void useSystemClass() {
        int[] arr1 = { 1, 2, 3};
        int[] arr2 = { 4, 5};
        int[] arrResult = new int[5];
        System.arraycopy(arr1, 0, arrResult, 0, 2);
        System.out.println(Arrays.toString(arrResult)); // [1, 2, 0, 0, 0]
        System.arraycopy(arr2, 0, arrResult, 1, 2);
        System.out.println(Arrays.toString(arrResult)); // [1, 4, 5, 0, 0]
    }

    private static void useArraysClass1() {
        int[] arr1 = { 1, 2, 3};
        int[] copiedArr1 = Arrays.copyOf(arr1, 5);
        int[] copiedArr2 = Arrays.copyOf(arr1, 2);
        System.out.println(Arrays.toString(copiedArr1)); // [1, 2, 3, 0, 0]
        System.out.println(Arrays.toString(copiedArr2)); //[1, 2]
    }

    private static void useArraysClass2() {
        int[] arr = { 1, 2, 3, 4, 5};
        int[] copied1 = Arrays.copyOfRange(arr, 1, 3); // [2, 3]
        int[] copied2 = Arrays.copyOfRange(arr, 1, 10); // [2, 3, 4, 5, 0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(copied1));
        System.out.println(Arrays.toString(copied2));
    }
}
