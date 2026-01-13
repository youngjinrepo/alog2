package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10816
public class NumberCard {

    // 계수 정렬 활용
    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[10000000 * 2 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < n; i++) {
            nums[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < m; i++) {
            sb.append(nums[Integer.parseInt(st.nextToken())+10000000] + " ");
        }
        System.out.println(sb);
    }

    //이진 검색 활용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key <= arr[mid]) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
