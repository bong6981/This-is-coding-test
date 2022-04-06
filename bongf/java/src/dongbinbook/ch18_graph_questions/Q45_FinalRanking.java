package dongbinbook.ch18_graph_questions;

import java.util.*;

// https://www.acmicpc.net/problem/3665
public class Q45_FinalRanking {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            dongbin();
        }
    }

    public static void dongbin() {
        int n = sc.nextInt();
        sc.nextLine();
        int[] indegree = new int[n+1];
        boolean[][] graph = new boolean[n+1][n+1];

        Integer[] prev = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                graph[prev[i]][prev[j]] = true;
                indegree[prev[j]] += 1;
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(graph[x][y]) {
                graph[x][y] = false;
                graph[y][x] = true;
                indegree[x]++;
                indegree[y]--;
                continue;
            }

            if(graph[y][x]) {
                graph[y][x] = false;
                graph[x][y] = true;
                indegree[y]++;
                indegree[x]--;
            }
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean certain = true;
        boolean cycle = false;

        for (int i = 0; i < n; i++) {
            if(q.isEmpty()) {
                cycle = true;
                break;
            }
            
            if(q.size() >= 2) {
                certain = false;
                break;
            }

            Integer now = q.poll();
            result.add(now);

            for (int j = 1; j <= n; j++) {
                if(graph[now][j]) {
                    indegree[j]--;
                    if(indegree[j] == 0) {
                        q.offer(j);
                    }
                }
            }
        }

        if(cycle) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        if(!certain) {
            System.out.println("?");
            return;
        }

        for (Integer r : result) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
