package ch4_implementation;

import java.util.Arrays;
import java.util.Scanner;

public class Ch4_4 {
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt();
        sc.nextLine();

        int [][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int cnt = 1;
        int turnC = 0;
        int tempX = x;
        int tempY = y;

        while (true) {
            if(turnC == 4) {
                tempX = x - dx[d];
                tempY = y - dy[d];
                if ((0<=tempX && tempX <= h) && ( 0 <= tempY && tempY <= w) && arr[tempX][tempY] == 0) {
                    x = tempX;
                    y = tempY;
                    cnt++;
                    turnC = 0;
                } else {
                    break;
                }
            }
            arr[x][y] = 1;
            if(d==0) {
                d =3;
            } else {
                d--;
            }
            tempX = x + dx[d];
            tempY = y + dy[d];
            turnC++;
            if ((0<=tempX && tempX <= h) && ( 0 <= tempY && tempY <= w) && arr[tempX][tempY] == 0) {
                x = tempX;
                y = tempY;
                cnt++;
                turnC = 0;
            }
        }
        return cnt;
    }
}
