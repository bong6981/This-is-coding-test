package dongbinbook.ch8_dp;

import java.util.Arrays;
import java.util.Scanner;

public class Ch8_8_EfficientMonetaryComposition {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
             arr[i] = sc.nextInt();
        }

        int[] d = new int[m+1];
        Arrays.fill(d, 10001);


        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j =arr[i]; j<=m; j++) {
                if(d[j-arr[i]] != 100001) {
                    d[j] = Math.min(d[j], d[j- arr[i]]+1);
                }
            }
        }

        if(d[m] == 10001) {
            return -1;
        }
        return d[m];
    }
}

/*
2 15
2
3
결과 5
 */

/*
3 4
3
5
7
결과 -1
 */
