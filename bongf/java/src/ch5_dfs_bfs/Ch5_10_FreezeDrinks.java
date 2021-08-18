package ch5_dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class Ch5_10_FreezeDrinks {
    private static int[][] arr;
    private final static int[][] move = {{-1, 0}, {1,0}, {0, -1}, {0,1}};
    private static int n, m;

    public static void main(String[] args) {
        System.out.println(solution());
    }
    public static int solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // dongbin : if(dobinCheckIce()) {cnt++;} :
                if(arr[i][j] == 0) {
                    cnt++;
                    checkIce(i,j);
                }
            }
        }
        return cnt;
    }

    private static void checkIce(int i, int j) {
        arr[i][j] = 1;
        for (int[] mp : move) {
            int nx = i + mp[0];
            int ny = j + mp[1];
            if( 0<=nx && nx < n &&  0<= ny && ny < m && arr[nx][ny] == 0) {
                checkIce(nx, ny);
            }
        }
    }

    //나는 checkIce의 함수에 넣기 전에 이미 값이 유효한지 체크한다면 동빈북은 이 함수 안에서 다 체크한다.
    public static boolean dongbinCheckIce(int x, int y) {
        // 주어진 범위를 벗어나는 경우에는 즉시 종료
        if (x <= -1 || x >=n || y <= -1 || y >= m) {
            return false;
        }
        // 현재 노드를 아직 방문하지 않았다면
        if (arr[x][y] == 0) {
            // 해당 노드 방문 처리
            arr[x][y] = 1;
            // 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
            dongbinCheckIce(x - 1, y);
            dongbinCheckIce(x, y - 1);
            dongbinCheckIce(x + 1, y);
            dongbinCheckIce(x, y + 1);
            return true;
        }
        return false;
    }
}

/*
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111
결과는 8
 */

/*
4 5
00110
00011
11111
00000
결과는 3
 */

