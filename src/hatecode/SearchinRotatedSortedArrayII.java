package hatecode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SearchinRotatedSortedArrayII
 * Creator : duqiang
 * Date : Sep, 2018
 * Description : TODO
 */
public class SearchinRotatedSortedArrayII {

    /**
     * 81. Search in Rotated Sorted Array II
     * Follow up for "Search in Rotated Sorted Array":
     What if duplicates are allowed?

     1 1 1 3 1

     time : O(logn) (worst : O(n))
     space : O(1);
     * @param nums
     * @param target
     * @return
     */

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return true;
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) end = mid;
                else start = mid;
            } else {
                if (nums[mid] <= target && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return true;
        if (nums[end] == target) return true;
        return false;
    }
    //this is interview frinendly
    //thinking process: find a target value in a rotated sorted array, 
    //so its start, end mid may not in one trend, so we need to fiure out a 
    //way how to proceed with binary search
    
    //draw two lines then it is easy to fiure out
    
    //the if/else logic mainly is to narrow down the search scope,
    // we mainly want to know whther we need to move left or right, so one quick
    //way is to detect target is in one trend, like start <= target <= mid, or 
    //mid <= target <= right
    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right -left) / 2;
            if (nums[left] == target) {
                return true;
            }
            // handle previous same situation, 
            if(nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            // this handles the case 2, mid fall into second ascend list
            } else if (nums[left] > nums[mid]) {
                if (nums[right] >= target && target >= nums[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            //nums[left] == nums[mid], so we move left one step
            } else {
                left++;
            }
        }
        if (nums[left] == target || nums[right] == target) {
                return true;
            }
       return false;
    }
}
