package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/12865
public class NormalBackpack {
    /*
4 7
6 13
4 8
3 6
5 12
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "", tmp;
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int[][] wv = new int[n][2];

        String[] ss = new String[2];
        for (int i = 0 ; i < n; i++) {
            ss = br.readLine().split(" ");
            wv[i][0] = Integer.parseInt(ss[0]);
            wv[i][1] = Integer.parseInt(ss[1]);
        }

        int result = solution(Integer.parseInt(s[1]), wv);

        System.out.println("result = " + result);
    }

    static public int solution( int k, int[][] wv ) {

        Arrays.sort(wv, (o1, o2) -> {
            if (o1[1] < o2[1]) {
                return 1;
            } else if (o1[1] > o2[1]) {
                return -1;
            } else
                return 0;
        });

        int backpack = 0, result = 0;
        for (int i = 0; i < wv.length; i++) {

            if ( wv[i][0] <= k ) {
                k = k - wv[i][0];
                result += wv[i][1];
            } else if ( k == 0 ) {
                return result;
            }
        }

        for (int[] ints : wv) {
            System.out.println(ints[0] + " " + ints[1]);
        }

        return result;
    }


}
