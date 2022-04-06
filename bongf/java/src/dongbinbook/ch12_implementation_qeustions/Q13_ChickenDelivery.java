package dongbinbook.ch12_implementation_qeustions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q13_ChickenDelivery {
    public List<List<Position>> chickenComb = new ArrayList<>();
    public List<Position> home;

    public static void main(String[] args) {
        Q13_ChickenDelivery chickenDelivery = new Q13_ChickenDelivery();
        System.out.println(chickenDelivery.solution());
    }

    public int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        home = new ArrayList<>();
        List<Position> chicken = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                if (x == 1) {
                    home.add(new Position(i, j));
                }
                if (x==2) {
                    chicken.add(new Position(i,j));
                }
            }
        }
        combination(new ArrayList<>(), 0, m, chicken);

        int result = (int) 1e9;
        for(List<Position> candidate : chickenComb) {
            result = Math.min(result, getLength(candidate));
        }
        return result;
    }

    public int getLength(List<Position> candidate) {
        int result = 0;
        for(Position h : home) {
            int temp = (int) 1e9;
            for(Position c : candidate) {
                temp = Math.min(temp, Math.abs(c.x - h.x) + Math.abs(c.y - h.y));
            }
            result += temp;
        }
        return result;
    }

    public void combination(List<Position> result, int start, int r, List<Position> chicken) {
        if(r==0) {
            // 고생했던 것 : 여기서 new ArrayList로 안하면 result가 안담긴다. 전역 변수라 그런듯
            chickenComb.add(new ArrayList<>(result));
            return;
        }

        for(int i= start; i<chicken.size(); i++) {
            result.add(chicken.get(i));
            combination(result, i+1,  r-1, chicken);
            result.remove(chicken.get(i));
        }
    }


}

class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
//5
 */
