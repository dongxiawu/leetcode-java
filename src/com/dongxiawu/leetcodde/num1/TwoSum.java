package com.dongxiawu.leetcodde.num1;

import java.util.Arrays;

/**
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);
        int[] result = new int[2];
        for (int i = 0, j = newNums.length -1; i < j;) {
            int total = newNums[i] + newNums[j];
            if (total == target) {
                result[0] = newNums[i];
                result[1] = newNums[j];
                break;
            } else if (total > target) {
                j--;
            } else {
                i++;
            }
        }
        int[] pos = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result[0] && pos[0] == -1) {
                pos[0] = i;
            } else if (nums[i] == result[1] && pos[1] == -1) {
                pos[1] = i;
            }
        }
        return pos;
    }
}
