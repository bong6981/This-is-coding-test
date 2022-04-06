package dongbinbook.ch18_graph_questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q41_TravelPlan {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i < n+1; i++) {
            Integer[] data = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            for (int j = 0; j < data.length; j++) {
                if(data[j] == 1) {
                    union(i, j+1);
                }
            }
        }
        Integer[] plans = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        boolean canGo = true;
        for (int i = 0; i < m-1; i++) {
            if(findParent(plans[i]) != findParent(plans[i+1])) {
                canGo = false;
                break;
            }
        }
        if(canGo) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }
    
    public static int findParent(int x) {
        if(parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }
    
    public static void union(int x, int y) {
        x = findParent(x);
        y = findParent(y);
        if(x < y) {
            parent[y] = x;
            return;
        }
        parent[x] = y;
    }
}

/*
5 4
0 1 0 1 1
1 0 1 1 0
0 1 0 0 0
1 1 0 0 0
1 0 0 0 0
2 3 4 3
 */
