package dongbinbook.ch4_implementation;

import java.util.Scanner;

public class Ch4_3 {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        String p = sc.nextLine();
        int x = p.charAt(0) - 'a' + 1;
        int y = Character.getNumericValue(p.charAt(1));
        // dongbin : int y = p.chartAt(1) - '0'

        int[][] move = {{2,1} , {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1,-2}, {-1, 2}, {-1, -2}};
        int cnt = 0;
        for (int[] ints : move) {
            int nx = ints[0];
            int ny = ints[1];
            if( 1<=nx && nx<=8 && 1 <= ny && ny <=8) {
                cnt++;
            }
        }
        return cnt;
    }
}
