package com.dongxiawu.leetcodde.num1;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        return twoSumSolution3(nums, target);
    }

    private int[] twoSumSolution1(int[] nums, int target) {
        // 复制，保持原有顺序
        int[] newNums = Arrays.copyOf(nums, nums.length);
        // 排序
        Arrays.sort(newNums);
        int[] result = new int[2];
        // 找目标数
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
        // 找目标位置
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

    private int[] twoSumSolution2(int[] nums, int target) {
        // 保存值和顺序的map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 找答案
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                // 获取顺序
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int[] twoSumSolution3(int[] nums, int target) {
        // 边找顺序边保存
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                // 获取顺序
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
