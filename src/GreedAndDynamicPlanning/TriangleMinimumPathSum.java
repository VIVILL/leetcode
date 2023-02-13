package GreedAndDynamicPlanning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/triangle/
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

 */
public class TriangleMinimumPathSum {
    public static void main(String[] args) {
        // [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3,4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6,5,7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4,1,8,3));

        List<List<Integer>> list = new ArrayList<>(Arrays.asList(list1,list2,list3,list4));
        System.out.println("minimumTotal = " + minimumTotal(list));
        System.out.println("minimumTotal1 = " + minimumTotal1(list));
        System.out.println("minimumTotal2 = " + minimumTotal2(list));

    }


    // 递归 https://leetcode.cn/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
    public static int minimumTotal(List<List<Integer>> triangle) {
        return  dfs(triangle, 0, 0);
    }

    private static int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }


    // 递归 + 记忆化 https://leetcode.cn/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
    static Integer[][] memo;
    public static int minimumTotal1(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return  dfs1(triangle, 0, 0);
    }

    private static int dfs1(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs1(triangle, i + 1, j), dfs1(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    // 动态规划
    // https://leetcode.cn/problems/triangle/solution/shou-hua-tu-jie-dp-si-lu-120-san-jiao-xing-zui-xia/
    // https://leetcode.cn/problems/triangle/solution/di-gui-ji-yi-hua-dp-bi-xu-miao-dong-by-sweetiee/
/*    定义二维 dp 数组，将解法二中「自顶向下的递归」改为「自底向上的递推」。
    自底向上动态规划，类似于从起点到目的地之间的最短路径
    https://leetcode.cn/problems/triangle/solution/zi-di-xiang-shang-dong-tai-gui-hua-lei-si-yu-cong-/*/
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }


}
