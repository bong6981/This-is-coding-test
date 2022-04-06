package dongbinbook.ch6_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ch6_10_TopBottom {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution()));
    }

    public static int[] solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for( int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        //dongbin : Arrays.sort Arrays.sort(arr, Comparator.reverseOrder()); 배열을 Integer로 선언해서 가능
        return Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(x->x).toArray();
    }
}
