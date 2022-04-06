package dongbinbook.ch6_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Ch6_12_ExchangeElementsInTwoArrays {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int[] arr1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(arr1);
        arr2 = Arrays.stream(arr2).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();


        for (int i = 0; i < k; i++) {
            if(arr1[i] < arr2[i]) {
                int temp = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = temp;
            } else {
                break;
            }
        }

        return IntStream.of(arr1).sum();
    }
}

/*
5 3
1 2 5 4 3
5 5 6 6 5
결과 26
 */
