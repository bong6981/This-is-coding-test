package ch12_implementation_qeustions;

public class Q10_LocksAndKeys {
    public static void main(String[] args) {
        Q10_LocksAndKeys locksAndKeys = new Q10_LocksAndKeys();
        System.out.println(locksAndKeys.solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }

    // dobin 풀이로 자바 연습
    public boolean solution(int[][] key, int[][] lock) {
        int n = key.length;
        int m = lock.length;

        int[][] graph = new int[m*3][m*3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                graph[i+m][j+m] = lock[i][j];
            }
        }
        for (int x = 0; x < 4; x++) {
            key = rotate(key);
            for (int i = 0; i < 2*m; i++) {
                for (int j = 0; j < 2*m; j++) {
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            graph[k+i][l+j] += key[k][l];
                        }
                    }
                    if(check(graph)) {
                        return true;
                    };
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            graph[k+i][l+j] -= key[k][l];
                        }
                    }
                }
            }
        }

        return false;
    }
    public int[][] rotate(int[][] origin) {
        int n = origin.length;
        int[][] newGraph = new int[n][n];
        for(int i = 0; i< n; i++) {
            for (int j = 0; j < n; j++) {
                newGraph[j][n-i-1] = origin[i][j];
            }
        }
        return newGraph;
    }
    public boolean check(int[][] graph) {
        int lockLength = graph.length / 3;
        for (int i = lockLength; i < lockLength*2; i++){
            for (int j=lockLength; j < lockLength*2; j++){
                if(graph[i][j] !=1){
                    return false;
                };
            }
        }
        return true;
    }
}
