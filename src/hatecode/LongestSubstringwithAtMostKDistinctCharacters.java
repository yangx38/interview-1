package hatecode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : LongestSubstringwithAtMostKDistinctCharacters
 * Creator : duqiang
 * Date : Aug, 2018
 * Description : 340. Longest Substring with At Most K Distinct Characters
 */
public class LongestSubstringwithAtMostKDistinctCharacters {
    /**
     * Given a string, find the length of the longest substring T that contains
     * at most k distinct characters.

     For example, Given s = “eceba” and k = 2,

     T is "ece" which its length is 3.

     sliding window

     time : O(n)
     space : O(1)

     * @param s
     * @param k
     * @return
     */
    //two pointers to find the longest
    // we scan the string s from 0 to s.length() - 1, 
    // we will increment num by having unique char until bigger than k, 
    // if it bigger, then we need another pointer j from beginning to scan to reduce num
    // and we try tested again. 
    // this will be biggest
    //note, when we count the chat, we ++ at end of count, but when we -- when left point moves
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            /* this also works to replace 41- 44
             *while (num > k) {
                if (--count[s.charAt(i++)]== 0) {
                    num--;
                }
             }
             */
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
