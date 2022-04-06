package dongbinbook.ch7_binary_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Ch7_8_MakeTteokbokkiRiceCake {
    public static void main(String[] args) {
        int start = 0;
        int end = (int) 1e9;
        System.out.println(end);
    }

    //dongbin 풀이에 sort를 더함 (더 작은 값들은 더이상 계산 안하게)
    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        Integer[] arr = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::valueOf)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        int start = 0;
        //dongbing : int end = (int) 1e9; (10의 9승)
        int end = arr[0];
        int answer = 0;

        while( start <= end ) {
            //dongbin : long으로 해야 한다. 범위 초과
            int total = 0;
            int mid = (start + end) /2;
            for(int l : arr) {
                if(l-mid <= 0){
                    break;
                }
                total += l-mid;
            }
            if(total < m) {
                end = mid -1;
            }else {
                answer = mid;
                start = mid + 1;
            }
        }
        return answer;
    }
}

/*
4 6
19 15 10 17
//결과값 15
 */
