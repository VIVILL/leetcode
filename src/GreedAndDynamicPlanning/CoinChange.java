package GreedAndDynamicPlanning;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/
 * 322. 零钱兑换
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 示例 1：

 输入：coins = [1, 2, 5], amount = 11
 输出：3
 解释：11 = 5 + 5 + 1
 示例 2：

 输入：coins = [2], amount = 3
 输出：-1
 示例 3：

 输入：coins = [1], amount = 0
 输出：0

 */
public class CoinChange {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5};

        System.out.println("coinChange = " + coinChange(nums1,11));// 超时版本
        System.out.println("coinChange1 = " + coinChange1(nums1,11));
        System.out.println("coinChange2 = " + coinChange2(nums1,11));// 19ms 版本
        System.out.println("coinChange3 = " + coinChange3(nums1,11));// 9ms 版本  优秀版本
    }

    // Java 递归、记忆化搜索、动态规划
    // https://leetcode.cn/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
    /*
    解题思路：
1.这种找路径，找方法的题一般可以使用回溯法来解决，回溯法也可以说是树形图法，解题的时候使用类似于树状图的结构，
使用 自顶而下 的方法。

2.而在回溯法中，如果含有很多的重复的计算的时候，就可以使用记忆化的搜索，将可能出现的重复计算大状态使用一个数组来保存其值，
在进行重复的计算的时候，就可以直接的调用数组中的值，较少了不必要的递归。

3.使用了记忆化搜索后，一般还可以进行优化，在记忆化搜索的基础上，变成 自底而上 的动态规划。
    * */

    /*
    * 递归
    使用递归的关键是知道递归函数是用来干什么的，从宏观的角度去理解递归。
    直接使用递归超出时间限制
    * */
    static int res = Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }

        findWay(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public static void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count);
        }

        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }

    // 记忆化搜索
    static int[] memo;
    public static int coinChange1(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return findWay1(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public static int findWay1(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = findWay1(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }

    // 19 ms 版本 动态规划
    public static int coinChange2(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for(int i = 1; i <= amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j < coins.length;j++){
                if(i - coins[j] >= 0 && memo[i-coins[j]] < min){
                    min = memo[i-coins[j]] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }


    // 9ms 版本 动态规划
    // https://leetcode.cn/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
    // 套「完全背包」问题的公式
    public static int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }



}
