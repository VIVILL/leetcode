package StackQueueAndRecursion;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * https://leetcode.cn/problems/longest-valid-parentheses/
 */

public class LongestValidParentheses {
    public static void main(String[] args) {
//        String s = "(()"; // 2
        String s = "(())"; // 4
        System.out.println("longestValidParentheses  = " + longestValidParentheses(s));
        System.out.println("longestValidParentheses1  = " + longestValidParentheses1(s));

    }

    // https://leetcode.cn/problems/longest-valid-parentheses/solution/java-dong-tai-gui-hua-by-tizzi-n2v1/
    // 栈版本
    public static int longestValidParentheses1(String s) {
        int n = s.length(), ans = 0;
        char[] arr = s.toCharArray();
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); //防止所有字符恰好匹配,栈底要为最后一个未被匹配的右括号下标
        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') st.push(i); //右括号直接入栈
            else {
                //遇到右括号直接弹出
                st.pop();
                if (st.isEmpty()) { //若为空代表把栈底最后一个未被匹配的括号弹出
                    st.push(i);
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }
        return ans;
    }

    // https://leetcode.cn/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/718987
    // 动态规划版本
    public static int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];//dp是以i处括号结尾的有效括号长度
        int max_len = 0;
        //i从1开始，一个是单括号无效，另一个是防i - 1索引越界
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == ')') { //遇见右括号才开始判断
                if(s.charAt(i - 1) == '(') { //上一个是左括号
                    if(i < 2) { //开头处
                        dp[i] = 2;
                    } else { //非开头处
                        dp[i] = dp[i - 2] + 2;
                    }
                }
                else { //上一个也是右括号
                    if(dp[i - 1] > 0) {//上一个括号是有效括号
                       //pre_left为i处右括号对应左括号下标，推导：(i-1)-dp[i-1]+1 - 1
                        int pre_left = i - dp[i - 1] - 1;
                        if(pre_left >= 0 && s.charAt(pre_left) == '(') {//左括号存在且为左括号（滑稽）
                            dp[i] = dp[i - 1] + 2;
                            //左括号前还可能存在有效括号
                            if(pre_left - 1 > 0) {
                                dp[i] = dp[i] + dp[pre_left - 1];
                            }
                        }
                    }
                }
            }
            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }

}
