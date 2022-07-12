package algorithm.algorithm;

public class UnionFind {
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

    public static void main(String[] args) {
        int[] parent = new int[11];
        for (int i = 1; i <= 10; i++)
            parent[i] = i;

        int nodeNum = 1;
        unionParent(parent, nodeNum++, nodeNum);
        unionParent(parent, nodeNum++, nodeNum);
        unionParent(parent, nodeNum++, nodeNum++);
        unionParent(parent, nodeNum++, nodeNum);
        unionParent(parent, nodeNum++, nodeNum);
        unionParent(parent, nodeNum++, nodeNum);

        System.out.println(findParent(parent, 1, 5));
        unionParent(parent, 1, 5);
        System.out.println(findParent(parent, 1, 5));
    }
}
