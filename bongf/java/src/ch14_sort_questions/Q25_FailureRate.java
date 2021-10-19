package ch14_sort_questions;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42889
public class Q25_FailureRate {
    public static void main(String[] args) {
        Q25_FailureRate fr = new Q25_FailureRate();
        System.out.println(Arrays.toString(fr.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(fr.solution(4, new int[]{4,4,4,4})));
    }
    public Integer[] solution(int n, int[] stages) {
        Arrays.sort(stages);
        int start = 0;
        int tried = stages.length;
        List<Node> nodes = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            int fail = 0;
            for(int j=start; j<stages.length; j++ ) {
                if(stages[j] == i) {
                    fail++;
                }
                if(stages[j] > i || j == stages.length-1) {
                    start = j;
                    nodes.add(new Node(i, fail, tried));
                    tried = stages.length - j;
                    break;
                }
            }
        }
        Collections.sort(nodes);
        Integer[] answer = new Integer[n];
        for(int i=0; i<n; i++) {
            answer[i] = nodes.get(i).index;
        }
        return answer;
    }

    class Node implements Comparable<Node> {
        int index;
        double failure;

        public Node(int index, int fail, int tried) {
            this.index = index;
            this.failure = ((double) fail) / tried;
        }

        @Override
        public int compareTo(Node other) {
            if (this.failure == other.failure) {
                return this.index - other.index;
            }
            return Double.compare(other.failure, this.failure);
        }
    }

    //이전에 풀었던 방법
    public static Integer[] solution2(int N, int[] stages) {
        int[] ing = new int[N+2];
        Map<Integer, Double> rate = new HashMap<>();
        for (int stage : stages) {
            ing[stage]++;
        }
        for (int i = 1; i <=N; i++) {
            int triedP = Arrays.stream(Arrays.copyOfRange(ing, i, ing.length)).sum();
            if( triedP == 0 ) {
                rate.put(i, 0.0);
            } else {
                rate.put(i, (double)ing[i] / triedP);
            }
        }
        return rate.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .toArray(Integer[]::new);
    }
}
