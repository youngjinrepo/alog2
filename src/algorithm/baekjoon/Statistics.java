package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/2108
public class Statistics{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[8001];
        int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, value;
        for (int i = 0 ; i < n; i++) {
            value = Integer.parseInt(br.readLine());
            sum += value;
            cnt[value + 4000]++;

            if (max < value) {max = value;}
            if (min > value) {min = value;}
        }

        int count = 0, mode_max = 0, median = 10000, mode = 10000;
        boolean flag = false;
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (cnt[i] > 0) {
                if (count < (n + 1) / 2) {
                    count += cnt[i];
                    median = i - 4000;
                }
                if (mode_max < cnt[i]) {
                    mode_max = cnt[i];
                    mode = i - 4000;
                    flag = true;
                } else if (mode_max == cnt[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / n));	// 산술평균
        System.out.println(median);	// 중앙값
        System.out.println(mode);	// 최빈값
        System.out.println(max - min);	// 범위
    }

    private static int[] solution(int[] nums) {

        sort(nums, 0, nums.length - 1);

        int[] cnt = new int[8001];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cnt[nums[i] + 4000]++;
        }

        int max[] = new int[2];
        int maxValue, tmp = -9999;
        for (int i = cnt.length - 1; i >= 0; i--) {
            if (cnt[i] == 0) continue;
            else if (cnt[i] > tmp) {
                tmp = cnt[i];
                max[0] = i - 4000;
                max[1] = -9999;
            } else if ( cnt[i] == tmp) {
                max[1] = max[0];
                max[0] = i - 4000;
            }
        }

        maxValue = -9999 == max[1] ? max[0] : max[1];

        int[] result = {
                sum / nums.length,
                nums[nums.length / 2],
                maxValue,
                nums[nums.length - 1] - nums[0]};
        return result;
    }

    public static void sort(int[] nums, int start, int end ) {
        if (start >= end){ return;}

        int i = start + 1,key = start, j = end, temp;

        while ( i<= j) {
            if (i <= end && nums[i] <= nums[key]) {
                i++;
            }
            if (j > start && nums[j] >= nums[key]) {
                j--;
            }
            if (i > j) {
                temp = nums[key];
                nums[key] = nums[j];
                nums[j] = temp;
            } else {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        sort(nums, start, j - 1);
        sort(nums, j + 1, end);
    }


}
