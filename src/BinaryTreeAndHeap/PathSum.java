package BinaryTreeAndHeap;

/**
 * https://leetcode.cn/problems/path-sum/
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *  5 + 4 + 11 + 2 = 22,所以返回 true
 *                            5
 *                       4         8
 *                   11         13    4
 *                 7    2                1
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 *     1
 *   2   3
 *
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。

 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println("treeNode hasPathSum = " + hasPathSum(treeNode,5));// treeNode hasPathSum = false
         /*                            5
          *                       4         8
          *                   11         13    4
          *                 7    2                1
          *  5 + 4 + 11 + 2 = 22,所以返回 true
       */

        TreeNode treeNode1 = new TreeNode(11,new TreeNode(7),new TreeNode(2));// 11 7 2
        TreeNode treeNode2 =  new TreeNode(4,null,new TreeNode(1));// 4 null 1

        TreeNode treeNode3 = new TreeNode(4,treeNode1,null);// 4 11 null 7 2 null
        TreeNode treeNode4 = new TreeNode(8,new TreeNode(13),treeNode2);// 8 13 4 null 1

        TreeNode treeNode5 =  new TreeNode(5,treeNode3,treeNode4);// 5,4,8,11,null,13,4,7,2,null,null,null,1
        System.out.println("treeNode5 hasPathSum = " + hasPathSum(treeNode5,22));// treeNode5 hasPathSum = true
    }

    // https://leetcode.cn/problems/path-sum/solution/lu-jing-zong-he-de-si-chong-jie-fa-dfs-hui-su-bfs-/
    // DFS
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }


}
