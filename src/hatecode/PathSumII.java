package hatecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duqiang on 28/07/2017.
 */
public class PathSumII {
    /**
     * 113. Path Sum II
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

     For example:
     Given the below binary tree and sum = 22,
           5
          / \
         4   8
        /   / \
       11  13  4
      /  \    / \
     7    2  5   1
     [
     [5,4,11,2],
     [5,8,4,5]
     ]
     time : O(n);
     space : O(n);
     * @param root
     * @param sum
     * @return
     */
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, new ArrayList<>(), root, sum);
        return res;
    }
    public static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                res.add(new ArrayList<>(list));
                // here we don return? because we if we return, we cannot remove the last element in the 
                // list, see list.remove(list.size() - 1), we have to stay in current stack until list will remove
                // the current element if we did not get the correct path
                // so the whole scan is more likely, we pre-order visit the tree and if we find a leaf node which
                // satisfy our needs, we just add to the result, the whole pipeline will remove the element if we cannot
                // find more correct way when we rereat to high level of the tree.
            }
        }
        helper(res, list, root.left, sum - root.val);
        helper(res, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}