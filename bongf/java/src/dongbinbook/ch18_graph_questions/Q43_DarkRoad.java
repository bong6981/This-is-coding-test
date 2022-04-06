package dongbinbook.ch18_graph_questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q43_DarkRoad {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] input1 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int n = input1[0];
        int m = input1[1];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Node[] roads = new Node[m];
        for (int i = 0; i < m; i++) {
            Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            roads[i] = new Node(input[0], input[1], input[2]);
        }

        Arrays.sort(roads);
        int result = 0;
        for (Node road : roads) {
            if(findP(road.x) != findP(road.y)) {
                union(road.x, road.y);
                continue;
            }
            result += road.distance;
        }
        return result;
    }

    public static int findP(int x) {
        if(parent[x] != x) {
            parent[x] = findP(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        x = findP(x);
        y = findP(y);
        if( x < y) {
            parent[y] = x;
            return;
        }
        parent[x] = y;
    }
}

class Node implements Comparable<Node>{
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
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
//51
 */
