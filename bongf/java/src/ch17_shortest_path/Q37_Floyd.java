package ch17_shortest_path;

import java.util.Arrays;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11404
public class Q37_Floyd {
    public static int INF = (int) 1e9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            /*
            dongbin :
            if(cost < graph[from][to]) graph[from][to] = cost;
             */
            if (graph[from][to] != INF) {
                graph[from][to] = Math.min(cost, graph[from][to]);
                continue;
            }
            graph[from][to] = cost;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == INF) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
