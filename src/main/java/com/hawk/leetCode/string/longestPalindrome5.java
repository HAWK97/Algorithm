package com.hawk.leetCode.string;

/**
 * 题目描述：给定一个字符串 s，找到 s 中最长的回文子串
 * 示例：输入: "babad" 输出: "bab" 注意: "aba"也是一个有效答案
 */
public class longestPalindrome5 {

    /**
     * 中心扩展算法
     * 解题思路：回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1 个这样的中心
     * 回文中心除了字符串中的每个字符，所含字母数为偶数的回文子串的中心可以处于两字母之间
     * 例如 “abba” 的中心在两个 ‘b’ 之间
     * 复杂度分析：时间复杂度 O(n^2)，由于围绕中心来扩展回文会耗去 O(n) 的时间，所以总的复杂度为 O(n^2)
     * 空间复杂度 O(1)
     */
    public String longestPalindrome1(String s) {
        // start、end分别为最长回文子串的起始与结束索引
        int start = 0;
        int end = 0;
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            // left最小值为0，right最大值为s.length() - 1
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left + 1;
                end = right - 1;
            }
            // 若回文子串为偶数串，则子串中心为left与right之间
            left = i;
            right = i + 1;
            while (left > -1 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left + 1;
                end = right - 1;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 动态规划
     * 解题思路：考虑 “ababa” 这个示例。如果我们已经知道 “bab” 是回文
     * 那么很明显，“ababa” 一定是回文，因为它的左首字母和右尾字母是相同的
     * 如果我们已经知道了一个子字符串[i + 1...j - 1]是回文的
     * 若s[i] = s[j]，就可以直接判断[i...j]是回文的
     * 因此可以用dp[i][j]表示s[i...j]是否回文
     * 复杂度分析：时间复杂度 O(n^2)
     * 空间复杂度 O(n^2)，该方法使用 O(n^2) 的空间来存储表
     */
    public String longestPalindrome2(String s) {
        // start、end分别为最长回文子串的起始与结束索引
        int start = 0;
        int end = 0;
        int maxLen = 1;
        int len = s.length();
        if (len < 1) {
            return "";
        }
        if (len == 1) {
            return s;
        }
        // 用dp[i][j]表示s[i...j]是否回文
        boolean[][] dp = new boolean[len][len];
        // dp数组初始条件有两种情况，分别是单个字符与两个相同字符
        for (int i = 0; i < len; i++) {
            // 单个字符
            dp[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                // 两个相同字符
                dp[i][i + 1] = true;
                start = i;
                end = i + 1;
                maxLen = 2;
            }
        }
        // 找到所有三字母回文，并以此类推
        for (int l = 3; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    end = j;
                    maxLen = l;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
