package GreedAndDynamicPlanning;

/**
 * https://leetcode.cn/problems/minimum-path-sum/
 * 64. 最小路径和
 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。
 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 输出：7
 解释：因为路径 1→3→1→1→1 的总和最小。

 1 3 1
 1 5 1
 4 2 1

 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[] nums1 = {1,3,1};
        int[] nums2 = {1,5,1};
        int[] nums3 = {4,2,1};
        int[][] nums = {nums1,nums2,nums3};
        System.out.println("minPathSum = " + minPathSum(nums));// 2ms
    }

    //动态规划 https://leetcode.cn/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-dong-tai-gui-hua-gui-fan-liu-c/
    public static int minPathSum(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) continue;
                else if(i == 0)  grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if(j == 0)  grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

}
