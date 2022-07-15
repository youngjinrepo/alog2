package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.acmicpc.net/problem/11399
public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        String[] s = br.readLine().split(" ");
        for (int i = 0 ; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(nums);
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
            sum += nums[i];
        }

        System.out.println(sum);
    }
}
