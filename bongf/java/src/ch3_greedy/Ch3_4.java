package ch3_greedy;

import java.util.Scanner;

public class Ch3_4 {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt = 0;

        while(true){
            int target = (int) (n/k) * k;
            cnt += n - target;
            n = target;

            if(n<k) {
                break;
            }
            cnt++;
            n = (int) n/k;
        }
        cnt += (n - 1);
        return cnt;
    }
}
