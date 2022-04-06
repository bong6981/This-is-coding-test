package dongbinbook.ch8_dp;

import java.util.Scanner;

public class Ch8_5_Make1 {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        if(x==1) {
            return 1;
        }
        int[] d = new int[30001];
        for(int i=2; i<x+1; i++) {
            d[i] = d[i-1]+1;
            if(i%2 == 0) {
                d[i] = Math.min(d[i], d[i/2] + 1);
            }
            if(i%3==0) {
                d[i] = Math.min(d[i], d[i/3] +1);
            }
            if(i%5==0) {
                d[i] = Math.min(d[i], d[i/5] +1);
            }
        }
        return d[x];
    }

}

/*
26
결과값 3
 */
