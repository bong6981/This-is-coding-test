package ch12_implementation_qeustions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 동빈북 활용
// https://programmers.co.kr/learn/courses/30/lessons/60061
public class Q12_InstallPillarsBo {
    public static void main(String[] args) {
        Q12_InstallPillarsBo installPillarsBo = new Q12_InstallPillarsBo();
    }

    public int[][] solution(int n, int[][] build_frame) {
        List<Node> answer = new ArrayList<>();

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int stuff = frame[2];
            int operate = frame[3];
            if (operate == 0) {
                answer.remove(new Node(x, y, stuff));
                if (!possible(answer)) {
                    answer.add(new Node(x, y, stuff));
                }
            } else {
                answer.add(new Node(x, y, stuff));
                if (!possible(answer)) {
                    answer.remove(new Node(x, y, stuff));
                }
            }
        }

        Collections.sort(answer);
        return toAnswer(answer);
    }

    public int[][] toAnswer(List<Node> answer) {
        int[][] toReturn = new int[answer.size()][3];
        for (int i = 0; i < answer.size(); i++) {
            Node node = answer.get(i);
            toReturn[i][0] = node.x;
            toReturn[i][1] = node.y;
            toReturn[i][2] = node.stuff;
        }
        return toReturn;
    }

    public boolean possible(List<Node> answer) {
        for (Node node : answer) {
            int x = node.x;
            int y = node.y;
            int stuff = node.stuff;
            if (stuff == 0) {
                if (y == 0 || answer.contains(new Node(x - 1, y, 1)) || answer.contains(new Node(x, y, 1)) || answer.contains(new Node(x, y - 1, 0))) {
                    continue;
                }
                return false;
            } else {
                if (answer.contains(new Node(x, y - 1, 0)) || answer.contains(new Node(x + 1, y - 1, 0)) || (answer.contains(new Node(x - 1, y, 1)) && answer.contains(new Node(x + 1, y, 1)))) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int stuff;

    public Node(int x, int y, int stuff) {
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }

    @Override
    public int compareTo(Node other) {
        if (this.x == other.x) {
            if (this.y == other.y) {
                return this.stuff - other.stuff;
            }
            return this.y - other.y;
        }
        return this.x - other.x;
    }

    @Override
    public boolean equals(Object o) {
        Node node = (Node) o;
        return x == node.x && y == node.y && stuff == node.stuff;
    }

    @Override
    public String toString() {
        return "Node{" +
                "x=" + x +
                ", y=" + y +
                ", stuff=" + stuff +
                '}';
    }
}
