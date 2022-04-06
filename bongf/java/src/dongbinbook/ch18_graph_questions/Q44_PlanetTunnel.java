package dongbinbook.ch18_graph_questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q44_PlanetTunnel {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        Planet[] x = new Planet[n];
        Planet[] y = new Planet[n];
        Planet[] z = new Planet[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            Integer[] input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            x[i] = new Planet(i, input[0]);
            y[i] = new Planet(i, input[1]);
            z[i] = new Planet(i, input[2]);
        }

        Arrays.sort(x);
        Arrays.sort(y);
        Arrays.sort(z);

        List<Path> paths = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            paths.add(new Path(x[i+1].position - x[i].position, x[i].index, x[i+1].index));
            paths.add(new Path(y[i+1].position - y[i].position, y[i].index, y[i+1].index));
            paths.add(new Path(z[i+1].position - z[i].position, z[i].index, z[i+1].index));
        }

        Collections.sort(paths);
        int result = 0;
        for (Path path : paths) {
            if( findP(path.x) != findP(path.y)) {
                union(path.x, path.y);
                result += path.distance;
            }
        }
        return result;
    }

    public static int findP(int x) {
        if(parent[x] != x) {
            parent[x] = findP(parent[x]);
        }
        return parent[x];
    }

    public static void union(int x, int y) {
        x = findP(x);
        y = findP(y);
        if( x < y ) {
            parent[x] = y;
            return;
        }
        parent[y] = x;
    }
}

class Planet implements Comparable<Planet> {
    int index;
    int position;

    public Planet(int index, int position) {
        this.index = index;
        this.position = position;
    }

    @Override
    public int compareTo(Planet other) {
        return this.position - other.position;
    }
}

class Path implements Comparable<Path> {
    int distance;
    int x;
    int y;

    public Path(int distance, int x, int y) {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Path path) {
        return this.distance - path.distance;
    }
}
