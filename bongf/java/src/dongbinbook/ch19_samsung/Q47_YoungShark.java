package dongbinbook.ch19_samsung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/19236
public class Q47_YoungShark {
    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node[][] graph = new Node[4][4];
        for (int i = 0; i < 4; i++) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                graph[i][j] = new Node(Integer.parseInt(input[j * 2]), Integer.parseInt(input[j * 2 + 1]) - 1);
            }
        }
        dfs(graph, 0, 0, 0);
        System.out.println(result);
    }

    public static int turnLeft(int d) {
        return (d + 1) % 8;
    }

    public static int[] findFish(Node[][] graph, int fishNum) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (graph[i][j].fishNum == fishNum) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static Node[][] moveFish(Node[][] graph, int sh_x, int sh_y) {
        for (int i = 0; i < 17; i++) {
            int[] position = findFish(graph, i);
            if (position != null) {
                int x = position[0];
                int y = position[1];
                int d = graph[x][y].d;
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (0 <= nx && nx < 4 && 0 <= ny && ny < 4) {
                        if (!(nx == sh_x && ny == sh_y)) {
                            graph[x][y].d = d;
                            Node temp = graph[nx][ny];
                            graph[nx][ny] = graph[x][y];
                            graph[x][y] = temp;
                            break;
                        }
                    }
                    d = turnLeft(d);
                }
            }
        }
        return graph;
    }

    public static List<int[]> possiblePositions(Node[][] graph, int sh_x, int sh_y) {
        List<int[]> positions = new ArrayList<>();
        int d = graph[sh_x][sh_y].d;
        for (int i = 0; i < 4; i++) {
            sh_x += dx[d];
            sh_y += dy[d];
            if (0 <= sh_x && sh_x < 4 && 0 <= sh_y && sh_y < 4) {
                if (graph[sh_x][sh_y].fishNum != -1) {
                    positions.add(new int[]{sh_x, sh_y});
                }
            }
        }
        return positions;
    }

    public static void dfs(Node[][] graph, int sh_x, int sh_y, int ate) {
        ate += graph[sh_x][sh_y].fishNum;
        graph = copyGraph(graph);
        graph[sh_x][sh_y].fishNum = -1;
        Node[][] new_graph = moveFish(graph, sh_x, sh_y);
        List<int[]> positions = possiblePositions(new_graph, sh_x, sh_y);
        if (positions.size() == 0) {
            result = Math.max(ate, result);
            return;
        }
        for (int[] position : positions) {
            dfs(new_graph, position[0], position[1], ate);
        }
    }

    public static Node[][] copyGraph(Node[][] graph) {
        Node[][] newGraph = new Node[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newGraph[i][j] = new Node(graph[i][j].fishNum, graph[i][j].d);
            }
        }
        return newGraph;
    }
}

class Node {
    int fishNum;
    int d;

    public Node(int fishNum, int d) {
        this.fishNum = fishNum;
        this.d = d;
    }
}
