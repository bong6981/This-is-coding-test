package dongbinbook.ch11_greedy_questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q4_AmountCannotBeMade {
    public static void main(String[] args) {
        Q4_AmountCannotBeMade amountCannotBeMade = new Q4_AmountCannotBeMade();
        System.out.println(amountCannotBeMade.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /* dongbin: (동빈 방법이 더 좋아보임) 어차피 한 번에 int로 넣기
        public static ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrayList.add(sc.nextInt());
        }
         Collections.sort(arrayList);
         */
        sc.nextLine();
        int[] input = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        Arrays.sort(input);
        int target = 1;
        for(int d : input) {
            if(target < d) {
                break;
            } else {
                target += d;
            }
        }
        return target;
    }
}

/*
5
3 2 1 1 9
결과값 8
 */
