package ch5_dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ch5_11_MazeEscape {
    private static int n, m;
    private static int[][] arr;
    private final static int[][] move = {{-1, 0}, {1,0}, {0, -1}, {0,1}};

    public static void main(String[] args) {
        System.out.println(dongbin());
    }

    public static int dongbin() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(""))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }
        return bfs(0,0);
    }

    public static int bfs(int x, int y) {
        //동빈북은 Node 클래스를 만들어 사용
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        while (!q.isEmpty()) {
            int [] polled = q.poll();
            x = polled[0];
            y = polled[1];
            for ( int[] mp : move ) {
                int nx = x + mp[0];
                int ny = y + mp[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m ) {
                    continue;
                }
                if (arr[nx][ny] == 0) {
                    continue;
                }
                if(arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return arr[n-1][m-1];
    }
}

/*
5 6
101010
111111
000001
111111
111111
결과는 10
 */
