package algorithm.algorithm;

import java.util.*;

public class Kruskal {

    public static void main(String[] args) {
        int n = 7, m = 11;

        List<Edge> v = new ArrayList<Edge>();
        v.add(new Edge(1, 7, 12));
        v.add(new Edge(1, 4, 28));
        v.add(new Edge(1, 2, 67));
        v.add(new Edge(1, 5, 17));
        v.add(new Edge(2, 5, 62));
        v.add(new Edge(2, 4, 24));
        v.add(new Edge(3, 5, 20));
        v.add(new Edge(3, 6, 37));
        v.add(new Edge(4, 7, 13));
        v.add(new Edge(5, 6, 45));
        v.add(new Edge(5, 7, 73));

        v.sort(Edge::compareTo);

        int[] parent = new int[n];
        for ( int i = 0; i < n; i++ ) {
            parent[i] = i;
        }

        int sum = 0;
        for (int i = 0; i < v.size(); i++ ) {
            Edge edge = v.get(i);
            if ( 0 == findParent(parent, edge.node[0] - 1, edge.node[1] - 1)) {
                sum += edge.distance;
                unionParent(parent, edge.node[0] - 1, edge.node[1] - 1);
            }
        }

        System.out.println(sum);
    }

    static public int getParent(int[] parent, int x) {
        if (parent[x] == x ) return x;
        return getParent(parent, parent[x]);
    }

    static void unionParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if ( a < b) parent[b] = a;
        else parent[a] = b;
    }

    static int findParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b) return 1;
        return 0;
    }

    private static class Edge implements Comparable<Edge>{
        int[] node = new int[2];
        int distance;

        public Edge(int a, int b, int distance) {
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.distance > edge.distance)
                return 1;
            else if (this.distance < edge.distance)
                return -1;
            else
                return 0;
        }
    }
}
