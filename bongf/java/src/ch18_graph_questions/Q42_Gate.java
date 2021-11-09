package ch18_graph_questions;

import java.util.Scanner;

public class Q42_Gate {
    public static int[] parent;
    public static void main(String[] args) {
        System.out.println(solution());
    }

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int g = sc.nextInt();
        int p = sc.nextInt();

        parent = new int[g+1];
        for (int i = 1; i <= g; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < p; i++) {
            int root = findParent(sc.nextInt());
            if(root == 0) {
                break;
            }
            union(root, root-1);
            result++;
        }
        return result;
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
4
3
4
1
1
//2
 */

/*
4
6
2
2
3
3
4
4
//3
 */
