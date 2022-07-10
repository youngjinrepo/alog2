package algorithm.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class BreathFirstSearch {

    public static void main(String[] args) {
        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};

        boolean[] visited = new boolean[9];

        System.out.println(bfs(1, graph, visited));
    }

    public static String bfs(int start, int[][] graph, boolean[] visited) {
       StringBuilder sb = new StringBuilder();

       Queue<Integer> q = new LinkedList<Integer>();
       q.offer(start);
       visited[start] = true;

        while (!q.isEmpty()) {
            int nodeIndex = q.poll();
            sb.append(nodeIndex + " -> ");

            for (int i = 0; i< graph[nodeIndex].length; i++) {
                int temp = graph[nodeIndex][i];

                if (!visited[temp]) {
                    visited[temp] = true;
                    q.offer(temp);
                }
            }
        }

       return sb.toString();
    }
}
