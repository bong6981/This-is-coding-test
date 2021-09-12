package ch10_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch10_7_TeamFormation {
    int[] parent;

    public static void main(String[] args) {
        Ch10_7_TeamFormation tf = new Ch10_7_TeamFormation();
        System.out.println(tf.solution());
    }

    public List<String> solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sign = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (sign == 1) {
                /*
                dongbin :
                 if (findParent(a) == findParent(b)) {
                    System.out.println("YES");
                }
                 */
                a = findP(a);
                b = findP(b);
                if (a == b) {
                    answer.add("YES");
                } else {
                    answer.add("NO");
                }
            }
            if (sign == 0) {
                union(a, b);
            }
        }
        return answer;
    }

    public int findP(int x) {
        if (parent[x] != x) {
            parent[x] = findP(parent[x]);
        }
        return parent[x];
    }

    public void union(int a, int b) {
        a = findP(a);
        b = findP(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
결과
NO
NO
YES
 */
