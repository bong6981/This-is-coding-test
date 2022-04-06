package dongbinbook.ch12_implementation_qeustions;

import java.util.ArrayList;
import java.util.List;

public class Q14_CheckExteriorWall {
    public List<List<Integer>> result;

    public static void main(String[] args) {
        Q14_CheckExteriorWall checkExteriorWall = new Q14_CheckExteriorWall();
        System.out.println(checkExteriorWall.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
    }

    public int solution(int n, int[] weak, int[] dist) {
        int[] longWeak = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            longWeak[i] = weak[i];
            longWeak[weak.length + i] = weak[i] + n;
        }
        int answer = dist.length + 1;
        result = new ArrayList<>();
        permutation(dist, 0, dist.length, dist.length);

        for (int start = 0; start < weak.length; start++) {
            for (int j = 0; j < result.size(); j++) {
                int cnt = 1;
                int position = weak[start] + result.get(j).get(cnt - 1);
                for (int k = start; k < start + weak.length; k++) {
                    if (position < longWeak[k]) {
                        cnt++;
                        if (cnt > dist.length) {
                            break;
                        }
                        position = longWeak[k] + result.get(j).get(cnt - 1);
                    }
                }
                answer = Math.min(cnt, answer);
            }
        }
        if (answer > dist.length) {
            return -1;
        }
        return answer;
    }

    private void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            List<Integer> toAdd = new ArrayList<>(r);
            for (int i = 0; i < depth; i++) {
                toAdd.add(arr[i]);
            }
            result.add(toAdd);
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    private void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}



