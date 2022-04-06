package dongbinbook.ch13_dfs_bfs_questions;

import java.util.*;
// https://programmers.co.kr/learn/courses/30/lessons/60063?language=java
public class Q22_MoveBlocks {
    public int target;
    public int[][] newBoard;
    public static void main(String[] args) {
        Q22_MoveBlocks mb = new Q22_MoveBlocks();
        System.out.println(mb.solution(new int[][]{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}));
    }

    public int solution(int[][] board) {
        target = board.length;
        newBoard = new int[target+2][target+2];
        for(int i=0; i<target+2; i++) {
            for(int j=0; j<target+2; j++) {
                newBoard[i][j] = 1;
                if( 1 <= i && i <= target && 1 <= j && j <= target) {
                    newBoard[i][j] = board[i-1][j-1];
                }
            }
        }

        Queue<Node> blockPosition = new LinkedList<>();
        Node start = new Node(1,2,1,1, 0);
        blockPosition.offer(start);
        Set<Node> visited = new HashSet<>();
        visited.add(start);

        while (!blockPosition.isEmpty()) {
            Node position = blockPosition.poll();

            if(position.contains(target, target)) {
                return position.time;
            }

            List<Node> nodes = getNext(position);
            for(Node node : nodes) {
                if(!visited.contains(node)) {
                    blockPosition.offer(node);
                    visited.add(node);
                }
            }
        }
        return 0;
    }

    public List<Node> getNext(Node prev) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        List<Node> togo = new ArrayList<>();

        for( int i = 0; i < 4; i++) {
            int nfx = prev.fx + dx[i];
            int nfy = prev.fy + dy[i];
            int nbx = prev.bx + dx[i];
            int nby = prev.by + dy[i];
            if(newBoard[nfx][nfy] == 0 && newBoard[nbx][nby] == 0) {
                togo.add(new Node(nfx, nfy, nbx, nby, prev.time+1));
            }
        }

        //가로로 놓여있는 경우
        int[] toadd = {-1, 1};
        if ( prev.fx == prev.bx ) {
            for(int i : toadd) {
                if( newBoard[prev.bx+i][prev.by] == 0 && newBoard[prev.fx+i][prev.fy] == 0) {
                    togo.add(new Node(prev.bx, prev.by, prev.bx + i, prev.by, prev.time+1));
                    togo.add(new Node(prev.fx, prev.fy, prev.fx + i, prev.fy, prev.time+1));
                }
            }
        } else if( prev.by == prev.fy) {
            for(int i : toadd) {
                if ( newBoard[prev.bx][prev.by + i] == 0 && newBoard[prev.fx][prev.fy+i] == 0 ) {
                    togo.add(new Node(prev.bx, prev.by, prev.bx, prev.by+i, prev.time+1));
                    togo.add(new Node(prev.fx, prev.fy, prev.fx, prev.fy+i, prev.time+1));
                }
            }
        }

        return togo;
    }

    class Node {
        int fx;
        int fy;
        int bx;
        int by;
        int time;

        public Node(int fx, int fy, int bx, int by, int time) {
            this.fx = fx;
            this.fy = fy;
            this.bx = bx;
            this.by = by;
            this.time = time;
        }

        public boolean contains(int x, int y) {
            return (this.fx == x && this.fy == y) || (this.bx == x && this.by == y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return (fx == node.fx && fy == node.fy && bx == node.bx && by == node.by) ||
                    (fx == node.bx && fy == node.by && bx == node.fx && by == node.fy);
        }

        @Override
        public int hashCode() {
            return Math.max(Objects.hash(fx, fy, bx, by), Objects.hash(bx,by,fx,fy));
        }
    }
}
