package ch11_greedy_questions;

import java.util.*;

public class Q6_MuziEatingShow {
    public static void main(String[] args) {
        /*
        sublist에 대해서 알게 되었다. 리스트의 부분만 정렬할 대 유용하다
         */
        List<Integer> t = new ArrayList<>();
        t.add(0, 5);
        t.add(1, 7);
        t.add(2, 1);
        t.subList(1, t.size()).sort(Integer::compareTo);
        System.out.println(t);

        Q6_MuziEatingShow muziEatingShow = new Q6_MuziEatingShow();
        System.out.println(muziEatingShow.solution(new int[]{3, 1, 2}, 5L));
    }

    public static class Node {
        public int time;
        public int num;

        public Node(int time, int num) {
            this.time = time;
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }

    Comparator<Node> CompTime = new Comparator<Node>() {
        @Override
        public int compare(Node node, Node t1) {
            return node.time - t1.time;
        }
    };

    Comparator<Node> CompNum = new Comparator<Node>() {
        @Override
        public int compare(Node one, Node two) {
            return one.num - two.num;
        }
    };

    // 유툽 풀이
    public int solution2(int[] food_times, long k) {
        List<Node> foods = new LinkedList<>();
        int n = food_times.length;
        for (int i = 0; i < n; i++) {
            foods.add(new Node(food_times[i], i+1));
        }

        foods.sort(CompTime);
        long pretime = 0;
        int idx = 0;


        for (Node food : foods) {
            long diff = food.time - pretime;
            if(diff != 0) {
                long spend = diff * n;
                if(spend <= k ) {
                    k -= spend;
                    pretime = food.time;
                } else {
                    k %= n;
                    foods.subList(idx, food_times.length).sort(CompNum);
                    return foods.get(idx + (int) k).num;
                }
            }
            idx++;
            n--;
        }
        return -1;
    }

    /*
    동빈북 풀이
    자꾸 효율성이 실패했는데 왜 그랬는지 확인해보니 stream으로 sum을 구해준 부분 때문이었다.
    stream이 for문을 도는 것 보다 효율성이 떨어지나 보다.
     */
    public int solution(int[] food_times, long k) {
//        long sum = Arrays.stream(food_times).sum();
        long sum = 0;
        for (int i = 0; i < food_times.length; i++) {
            sum += food_times[i];
        }
        if(sum <= k) {
            return -1;
        }

        PriorityQueue<Food> q = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            q.offer(new Food(food_times[i], i+1));
        }

        // 타입을 long으로 잡기!
        long ate = 0;
        long previous = 0;
        long length = food_times.length;

        while( ate + (q.peek().getHour() - previous) * length <= k) {
            Food now = q.poll();
            ate += (now.getHour() - previous) * length;
            length -= 1;
            previous = now.getHour();
        }

        List<Food> result = new ArrayList<>();
        while(!q.isEmpty()) {
            result.add(q.poll());
        }

        result.sort(Comparator.comparingInt(Food::getNum));
        return result.get(((int) ((k-ate) % length))).getNum();
    }
}

class Food implements Comparable<Food> {
    private int hour;
    private int num;

    public Food(int hour, int num) {
        this.hour = hour;
        this.num = num;
    }

    public int getHour() {
        return hour;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Food other) {
        /*
        dongbin :
           return Integer.compare(this.time, other.time);
         */
        if(this.hour < other.hour) {
            return -1;
        }
        return 1;
    }
}
