package leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : MaximumSizeSubarraySumEqualsk
 * Creator : duqiang
 * Date : Aug, 2018
 * Description : 325. Maximum Size Subarray Sum Equals k
 */
public class MaximumSizeSubarraySumEqualsk {
    /**
     * 
     * 325. Maximum Size Subarray Sum Equals k
Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
If there isn't one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

     [1, -1, 5, -2, 3]  k = 3

     1, 0, 5, 3, 6  k = 3

     time : O(n)
     space : O(n)

     * @param nums
     * @param k
     * @return
     */
    // this is interview friendly solution, but thinking about if not K, just maxium, DP? LeetCode 53 is 
    // this type
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        // we have sum them up
        //nums[i] = nums[0] + .. nums[i - 1]
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                // map.get(nums[i] - k) means the rest sum in array which means the length of the array
                //  i - map.get(nums[i] - k) means the length
                res = Math.max(res, i - map.get(nums[i] - k));
            }
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        return res;
    }
    //another short solution
    public int maxSubArrayLen2(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }
}
