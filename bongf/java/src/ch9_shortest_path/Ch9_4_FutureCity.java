package ch9_shortest_path;

import java.util.Arrays;
import java.util.Scanner;

public class Ch9_4_FutureCity {
    public static final int INF = (int) 1e9;
    public static void main(String[] args) {
        Ch9_4_FutureCity fc = new Ch9_4_FutureCity();
        System.out.println(fc.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[][] graph = new int[n+1][n+1];
        Arrays.stream(graph).forEach(x-> Arrays.fill(x, INF));

        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            /*
            동빈북
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
             */
            Integer[] input = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
            graph[input[0]][input[1]] = 1;
            graph[input[1]][input[0]] = 1;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                for (int s = 0; s < n+1; s++) {
                    /*
                    동빈북 : graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                     */
                    int tocompare = graph[j][i] + graph[i][s];
                    if(graph[j][s] > tocompare) {
                        graph[j][s] = tocompare;
                    }
                }
            }
        }

        int answer = graph[1][k] + graph[k][x];
        if(answer >= INF) {
            return -1;
        }
        return answer;
    }
}

/*
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
결과 3
 */

/*
4 2
1 3
2 4
3 4
결과 -1
 */
