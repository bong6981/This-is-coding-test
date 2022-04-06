package dongbinbook.ch19_samsung;

import java.util.*;

public class Q46_BabyShark {
    public static int s;
    public static int[][] graph;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextInt();
        graph = new int[s][s];
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                int x = sc.nextInt();
                if(x==9) {
                    startX = i;
                    startY = j;
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = x;
            }
        }

        int size = 2;
        int ate = 0;
        int time = 0;

        while(true) {
            ToGo possible = findPossible(startX, startY, size);
            if(possible == null) {
                break;
            }
            time += possible.time;
            ate++;
            if(ate == size) {
                size++;
                ate = 0;
            }
            graph[possible.x][possible.y] = 0;
            startX = possible.x;
            startY = possible.y;
        }
        System.out.println(time);
    }
    public static ToGo temp() {
        return null;
    }

    public static ToGo findPossible(int x, int y, int size) {
        int[][] visited = new int[graph.length][graph.length];
        visited[x][y] = -1;
        int time = 0;
        Queue<ToGo> positions = new LinkedList<>();
        positions.offer(new ToGo(0, x, y));

        List<ToGo> possibleDestinations = new ArrayList<>();
        while(!positions.isEmpty()) {
            ToGo togo = positions.poll();
            for (int i = 0; i < 4; i++) {
                int nx = togo.x + dx[i];
                int ny = togo.y + dy[i];
                int nTime = togo.time + 1;
                if (0 <= nx && nx < s && 0 <= ny && ny < s && visited[nx][ny] != -1) {
                    if ((graph[nx][ny] == size) || (graph[nx][ny] == 0)) {
                        positions.add(new ToGo(nTime, nx, ny));
                        visited[nx][ny] = -1;
                        continue;
                    }
                    if (graph[nx][ny] < size) {
                        possibleDestinations.add(new ToGo(nTime, nx, ny));
                        visited[nx][ny] = -1;
                    }
                }
            }
        }
        if(possibleDestinations.size() == 0) {
            return null;
        }
        Collections.sort(possibleDestinations);
        return possibleDestinations.get(0);
    }
}

class ToGo implements Comparable<ToGo> {
    int time;
    int x;
    int y;

    public ToGo(int time, int x, int y) {
        this.time = time;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(ToGo other) {
        if(this.time == other.time) {
            if(this.x == other.x) {
                return this.y - other.y;
            }
            return this.x - other.x;
        }
        return this.time - other.time;
    }
}
