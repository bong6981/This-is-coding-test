package ch9_shortest_path;

import java.util.*;

public class Ch9_5_Telegram {
    public static final int INF = (int) 1e9;
    public int[] distance;
    public List<List<Node>> graph;

    public static void main(String[] args) {
        Ch9_5_Telegram t = new Ch9_5_Telegram();
        System.out.println(t.solution());
    }

    public String solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        distance = new int[n+1];
        Arrays.fill(distance, INF);

        graph = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
             int x = sc.nextInt();
             int y = sc.nextInt();
             int z = sc.nextInt();
             graph.get(x).add(new Node(y, z));
        }

        dijkstra(c);
        int count = 0;
        int maxD = 0;
        for (int i=1; i <= n; i++){
            if( distance[i] != INF && distance[i] != 0) {
                count++;
                maxD = Math.max(maxD, distance[i]);
            }
        }
        return count + " " + maxD;
    }

    public void dijkstra(int c) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(c, 0));
        distance[c] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.getDistance();
            int idx = node.getIndex();
            if( distance[idx] < dist) {
                continue;
            }
            for( Node n : graph.get(idx)) {
                int cost = dist + n.getDistance();
                if ( cost < distance[n.getIndex()]) {
                    distance[n.getIndex()] = cost;
                    pq.offer(new Node(n.getIndex(),cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node other) {
        if( this.distance < other.distance) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "(" + "idx=" + index +
                ", dist=" + distance + ")";
    }
}

/*
3 2 1
1 2 4
1 3 2
결과 2 4
 */
