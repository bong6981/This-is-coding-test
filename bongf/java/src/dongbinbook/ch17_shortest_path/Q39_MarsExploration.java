package dongbinbook.ch17_shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q39_MarsExploration {
    public static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            System.out.println(exploration());
        }
    }

    public static int exploration() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 0; j < n; j++) {
                board[i][j] = input[j];
            }
        }

        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        int[] dx = { -1, 0, 1, 0};
        int[] dy = { 0, 1, 0, -1};

        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.offer(new Node(0, 0, board[0][0]));
        distance[0][0] = board[0][0];
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(distance[now.x][now.y] < now.distance) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(0 <= nx && nx < n && 0 <= ny && ny <n) {
                    int cost = board[nx][ny] + now.distance;
                    if(cost < distance[nx][ny]) {
                        distance[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }
        }
        return distance[n-1][n-1];
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

/*
1
3
5 5 4
3 9 1
3 2 7
 */

/*
1
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
 */

/*
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
 */
