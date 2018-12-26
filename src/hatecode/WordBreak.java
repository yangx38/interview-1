package hatecode;

import java.util.List;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : WordBreak
 * Creator : duqiang
 * Date : Sep, 2018
 * Description : 139. Word Break
 */
public class WordBreak {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * You may assume the dictionary does not contain duplicate words.

     For example, given
     s = "leetcode",
     dict = ["leet", "code"].

     Return true because "leetcode" can be segmented as "leet code".

     time : O(n^2);
     space : O(n);

     s = "leetcode",
     dict = ["leet", "code"]


     * @param s
     * @param wordDict
     * @return
     */
    // thinking progress:
    // the problem is say yse or no when wordDict contains substrings of s or not space seperated
    
    // typical DP, 0 <= j <i, 
    // dp[j] means substring s[0, j] is in dic, so dp[i] = dp[j] && dic.conains(s[j,i)
    
    //key: 1. i = s.length() 
    //2 i < i cannot be =
    // for last char we have to access, we always use dp[n +1]
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            //we break because already find it, so we skip to next i
            // this for loop is mainly to verify j, i is in the dict or not
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}