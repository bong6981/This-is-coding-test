package ch12_implementation_qeustions;

import java.util.*;

public class Q11_Snake {
    public static void main(String[] args) {
        Q11_Snake snake = new Q11_Snake();
        System.out.println(snake.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] graph = new int[n+1][n+1];


        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }


        int l = sc.nextInt();
        String[][] turns = new String[l][2];
        for (int i = 0; i < l; i++) {
            String x = sc.next();
            String y = sc.next();
            turns[i][0] = x;
            turns[i][1] = y;
        }

        int[][] moves = {{0, 1}, {1,0}, {0,-1}, {-1,0}};

        int x = 1;
        int y = 1;
        graph[x][y] = 2;
        int direction = 0;
        int time = 0;
        int index = 0;
        Queue<List<Integer>> snake = new LinkedList<>();
        List<Integer> p = new ArrayList<>();
        p.add(x);
        p.add(y);
        snake.offer(p);

        while (true) {
            int nx = x + moves[direction][0];
            int ny = y + moves[direction][1];

            if(1<=nx && nx <= n&& 1<= ny && ny <= n && graph[nx][ny] != 2) {
                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = 2;
                    List<Integer> newP = new ArrayList<>();
                    newP.add(nx);
                    newP.add(ny);
                    snake.offer(newP);
                    List<Integer> outP = snake.poll();
                    graph[outP.get(0)][outP.get(1)] = 0;
                }
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = 2;
                    List<Integer> newP = new ArrayList<>();
                    newP.add(nx);
                    newP.add(ny);
                    snake.offer(newP);
                }
            } else {
                time += 1;
                break;
            }
            x = nx;
            y = ny;
            time += 1;
            if(index < l && time == Integer.parseInt(turns[index][0])) {
                direction = turn(direction, turns[index][1]);
                index += 1;
            }
        }
        return time;
    }

    public int turn(int direction, String c) {
        if ( c.equals("L") ) {
            return direction == 0 ? 3 : direction -1;
        }
        return (direction + 1) % 4;
    }


    //only for python
//    public int turn(int direction, String c) {
//        if(c.equals("L")) {
//            return (direction-1) % 4;
//        }
//        return (direction+1) % 4;
//    }
}
