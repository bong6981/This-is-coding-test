package ch16_dp_questions;

import java.util.*;

public class Q35_UglyNumber {
    public static void dongbin() {
        int n;
        int[] ugly = new int[1000]; // 못생긴 수를 담기 위한 테이블 (1차원 DP 테이블)

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 2배, 3배, 5배를 위한 인덱스
        int i2 = 0, i3 = 0, i5 = 0;
        // 처음에 곱셈 값을 초기화
        int next2 = 2, next3 = 3, next5 = 5;

        ugly[0] = 1; // 첫 번째 못생긴 수는 1
        // 1부터 n까지의 못생긴 수들을 찾기
        for (int l = 1; l < n; l++) {
            // 가능한 곱셈 결과 중에서 가장 작은 수를 선택
            ugly[l] = Math.min(next2, Math.min(next3, next5));
            System.out.println("++++++++++++");
            System.out.println(l);
            System.out.println(next2);
            System.out.println(next3);
            System.out.println(next5);
            System.out.println(ugly[l]);
            // 인덱스에 따라서 곱셈 결과를 증가
            if (ugly[l] == next2) {
                i2 += 1;
                next2 = ugly[i2] * 2;
                System.out.println("---------");
                System.out.println(i2);
                System.out.println(next2);
            }
            if (ugly[l] == next3) {
                i3 += 1;
                next3 = ugly[i3] * 3;
                System.out.println("---------");
                System.out.println(i3);
                System.out.println(next3);
            }
            if (ugly[l] == next5) {
                i5 += 1;
                next5 = ugly[i5] * 5;
                System.out.println("---------");
                System.out.println(i5);
                System.out.println(next5);
            }
        }
    }

    public static void main(String[] args) {
        dongbin();
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int v = 5;
//        List<Integer> dp = new ArrayList<>();
//        for (int i = 0; i <= 5; i++) {
//            dp.add(i);
//        }
//        if(n <=5) {
//            System.out.println(n);
//            return;
//        }
//        int num = 5;
//        while(n != v) {
//            num++;
//            List<Integer> factors = new ArrayList<>();
//            for(int i=1; i<= Math.sqrt(num); i++) {
//                if(num % i == 0) {
//                    factors.add(i);
//                    if(i != (num / i)) {
//                        factors.add(num/i);
//                    }
//                }
//            }
//            Collections.sort(factors);
//            boolean right = true;
//            int cnt = 0;
//            for(int i : factors) {
//                if(dp.size() -1 < i) {
//                    if(cnt == 1) {
//                        right = false;
//                        break;
//                    }
//                    break;
//
//                }
//                if(dp.get(i) == 0) {
//                    right = false;
//                    break;
//                }
//                cnt++;
//            }
//            if(right) {
//                for(int j=dp.size()-1; j>=0; j--) {
//                    if(dp.get(j) != 0) {
//                        dp.add(dp.get(j) +1);
//                        break;
//                    }
//                }
//                v++;
//            }
//            if(!right) {
//                dp.add(0);
//            }
//        }
//        System.out.println(dp.size()-1);
    }
}
