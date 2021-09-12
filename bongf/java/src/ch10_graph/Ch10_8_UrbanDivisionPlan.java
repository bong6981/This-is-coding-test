package ch10_graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 나는 edges를 2차원 배열로, 동빈북은 Edge 클래스 하나를 만들어 List<Edge> edges;로 만들었다.
public class Ch10_8_UrbanDivisionPlan {
    int[] parent;

    public static void main(String[] args) {
        Ch10_8_UrbanDivisionPlan udp = new Ch10_8_UrbanDivisionPlan();
        System.out.println(udp.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[][] edges = new int[m+1][3];
        for (int i = 0; i < m; i++) {
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
            edges[i][0] = sc.nextInt();
        }

        Arrays.sort(edges, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] ints, int[] t1) {
                        Integer a = 1;
                        Integer b = 2;
                        return Integer.compare(ints[0], t1[0]);
                    }
        });

        int result = 0;
        int max = 0;
        for( int[] edge : edges) {
            int x = findP(edge[1]);
            int y = findP(edge[2]);
            if( x!= y) {
                union(x, y);
                result += edge[0];
                // 어차피 길이 순서대로 정렬되어 굳이 max를 갱신할 때 이를 확인할 필요가 없다.
                /*
                max = edge[0]
                 */
                if( max < edge[0] ) {
                    max = edge[0];
                }
            }
        }
        return result-max;
    }

    public int findP(int x) {
        if(parent[x] != x) {
            parent[x] = findP(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        x = findP(x);
        y = findP(y);
        if ( x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }
}

//dongbin
class Edge implements Comparable<Edge> {

    private int distance;
    private int nodeA;
    private int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getNodeA() {
        return this.nodeA;
    }

    public int getNodeB() {
        return this.nodeB;
    }

// 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Edge other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}


/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
// 결과 8
 */
