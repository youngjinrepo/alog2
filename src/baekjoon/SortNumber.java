package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2750
public class SortNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int[] nums = new int[n];

        String ss;
        for (int i = 0 ; i < n; i++) {
            ss = br.readLine();
            nums[i] = Integer.parseInt(ss);
        }

        int[] result = solution(nums);

        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] solution(int[] nums) {
        int tmp;
        for (int i = 0; i < nums.length -1; i++ ) {
            for (int j = i+1; j < nums.length; j++) {
                if ( nums[i] > nums[j] ) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }
}
