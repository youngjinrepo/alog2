import java.io.*;
import java.util.*;

public class BOJ13549 {
    static final int MAX = 100;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(minTime(N, K));
    }

    static int minTime(int N, int K) {
        if (N >= K) return N - K; // 뒤로만 가면 되므로 전부 비용 1

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, INF);

        Deque<Integer> dq = new ArrayDeque<>();
        dist[N] = 0;
        dq.add(N);

        while (!dq.isEmpty()) {
            int x = dq.pollFirst();
            if (x == K) return dist[x];

            // 0초 이동: x -> 2x
            int nx = x * 2;
            if (nx <= MAX && dist[nx] > dist[x]) {
                dist[nx] = dist[x];  
                dq.addFirst(nx);
            }

            // 1초 이동: x -> x-1
            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }

            // 1초 이동: x -> x+1 
            nx = x + 1;
            if (nx <= MAX && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.addLast(nx);
            }
        }

        return dist[K];
    }
}
