package dongbinbook.ch10_graph;

import java.util.*;

public class Ch10_9_Curriculum {
    public static void main(String[] args) {
        Ch10_9_Curriculum c = new Ch10_9_Curriculum();
        System.out.println(Arrays.toString(c.solution()));
    }

    public int[] solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] time = new int[n+1];
        int[] indegree = new int[n+1];

       List<List<Integer>> graph = new ArrayList<>();
       graph.add(new ArrayList<>());

        for (int i = 1; i < n+1; i++) {
            Integer[] in = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);

            time[i] = in[0];
            graph.add(new ArrayList<>());
            for (int j = 1; j < in.length-1; j++) {
                graph.get(in[j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int j = 1; j <= n; j++) {
            if(indegree[j] == 0) {
                q.offer(j);
            }
        }

        int[] result = Arrays.copyOf(time, time.length);
        while(!q.isEmpty()) {
            int now = q.poll();
            for(  int x : graph.get(now)) {
                result[x] = Math.max(result[x], time[x] + result[now]);
                indegree[x]--;
                if(indegree[x] == 0) {
                    q.offer(x);
                }
            }
        }
        return Arrays.copyOfRange(result, 1, result.length);
    }
}

/*
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
결과
10
20
14
18
17
 */
