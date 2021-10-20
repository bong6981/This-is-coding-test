package etc;

import java.util.*;

// https://recruit.nhn.com/pdf/%ED%94%84%EB%A6%AC%ED%85%8C%EC%8A%A4%ED%8A%B8_1%EC%B0%A8_%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C.pdf
public class NHNPretest {
    public static int[][] graph;
    public static int[][] visited;
    public static int n;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new int[n][n];
        visited = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j] == 0 && graph[i][j] == 1) {
                    answer.add(visit(i, j));
                    cnt++;
                }
            }
        }
        if(answer.size() == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(cnt);
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            if(i != answer.size()-1) {
                System.out.print(" ");
            }
        }
    }

    private static int visit(int x, int y) {
        int cnt = 0;
        cnt++;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visited[x][y] = 1;
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{x,y});

        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            x = now[0];
            y = now[1];
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if( 0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if(visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                        cnt += visit(nx, ny);
                        q.offer(new Integer[]{nx, ny});
                    }
                }
            }
        }
        return cnt;
    }
}
