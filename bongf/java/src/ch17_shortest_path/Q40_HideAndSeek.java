package ch17_shortest_path;

import java.util.*;

public class Q40_HideAndSeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 동빈과 다른 점. 동빈은 Place를 넣어줬고 난 그냥 어차피 거리는 1이니까 Integer로 인덱스를 넣어줌
        List<List<Integer>> path = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            path.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            path.get(x).add(y);
            path.get(y).add(x);
        }

        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        d[1] = 0;

        PriorityQueue<Place> pq = new PriorityQueue<>();
        pq.add(new Place(1, 0));

        while (!pq.isEmpty()) {
            Place now = pq.poll();
            if (d[now.index] < now.distance) {
                continue;
            }
            for (Integer togo : path.get(now.index)) {
                int cost = now.distance + 1;
                if (cost < d[togo]) {
                    d[togo] = cost;
                    pq.add(new Place(togo, cost));
                }
            }
        }

        int maxDistance = 0;
        int placeToHide = 0;
        List<Integer> toHide = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (maxDistance < d[i]) {
                maxDistance = d[i];
                placeToHide = i;
                toHide = new ArrayList<>();
                toHide.add(i);
            } else if (maxDistance == d[i]) {
                toHide.add(i);
            }
        }
        System.out.print(placeToHide + " ");
        System.out.print(maxDistance + " ");
        System.out.print(toHide.size());
    }
}

class Place implements Comparable<Place> {
    int index;
    int distance;

    public Place(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Place other) {
        return this.distance - other.distance;
    }
}

/*
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
