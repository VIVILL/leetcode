package StackQueueAndRecursion;

import java.util.HashMap;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * https://leetcode.cn/problems/climbing-stairs/
 */

public class ClimbingStairs {

    /*
        输入：n = 2 输出：2
        输入：n = 3 输出：3
    * */
    public static void main(String[] args) {
        System.out.println("climbStairs  = " + climbStairs(2));
        System.out.println("climbStairs1  = " + climbStairs1(2));
        System.out.println("climbStairs2  = " + climbStairs2(2));
        System.out.println("========");
        System.out.println("climbStairs  = " + climbStairs(3));
        System.out.println("climbStairs1  = " + climbStairs1(3));
        System.out.println("climbStairs2  = " + climbStairs2(3));
    }

    // 动态规划与递归
    // https://www.jianshu.com/p/3426660df91d
    /*
        动态规划其实就是把一个复杂的最优解问题分解成一系列较为简单的最优解问题，再将较为简单的最优解问题一步步分解，
        直到能够一眼看出为止。动态规划看起来跟递归很像，不过推理逻辑正好是反过来的。* */

    // 使用递归
    // https://leetcode.cn/problems/climbing-stairs/solution/by-quirky-elbakyanpxx-kef0/
    //1.递归写法
    //使用数组/集合记录已经计算出来的数，减少重复计算的时间
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(map.get(n) != null){
            return map.get(n);
        } else{
            int result = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, result);
            return result;
        }
    }


    // https://leetcode.cn/problems/climbing-stairs/solution/hua-jie-suan-fa-70-pa-lou-ti-by-guanpengchn/
    // 使用斐波那契数列公式
    public static int climbStairs1(int n) {
        double sqrt_5 = Math.sqrt(5);
        double fib_n = Math.pow((1 + sqrt_5) / 2, n + 1) - Math.pow((1 - sqrt_5) / 2,n + 1);
        return (int)(fib_n / sqrt_5);
    }

    // 使用动态规划
    public static int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
