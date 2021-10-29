package ch13_dfs_bfs_questions;

import java.util.*;

public class Q15_FindCityOfCertainDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();

        List<List<Integer>> board = new ArrayList<>();
        int[] sd = new int[n+1];
        for (int i = 0; i <= n; i++) {
            board.add(new ArrayList<>());
            sd[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to  = sc.nextInt();
            board.get(from).add(to);
        }

        sd[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()) {
            Integer now = q.poll();
            List<Integer> toGo = board.get(now);
            for (Integer go : toGo) {
                if(sd[go] == -1) {
                    sd[go] = sd[now] + 1;
                    q.offer(go);
                }
            }
        }

        boolean found = false;
        for (int i = 0; i <= n; i++) {
            if(sd[i] == k) {
                System.out.println(i);
                found = true;
            }
        }
        if(!found) {
            System.out.println(-1);
        }
    }
}
