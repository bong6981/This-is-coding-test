package dongbinbook.ch3_greedy;

public class Ch3_1 {
    public static void main(String[] args) {
        System.out.println(solution(1260));
    }

    public static int solution(int change) {
        int[] t = {500, 100, 50, 10};
        int answer = 0;
        for (int i : t) {
            answer += change / i;
            change %= i;
        }
        return answer;
    }
}
