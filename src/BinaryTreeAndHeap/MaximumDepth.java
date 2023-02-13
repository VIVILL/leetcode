package BinaryTreeAndHeap;

/**给定一个二叉树，找出其最大深度。

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

 说明: 叶子节点是指没有子节点的节点。

 示例：
 给定二叉树 [3,9,20,null,null,15,7]，
 返回它的最大深度 3
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepth {
    public static void main(String[] args) {
        //二叉树  2,1,3
        /*    2
            1   3
        */
        TreeNode treeNode = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println("treeNode maxDepth = " + maxDepth(treeNode));//treeNode maxDepth = 2
       /*     1
          2       2
       1    3   1    3
       */
        TreeNode treeNode1 = new TreeNode(1,treeNode,treeNode);
        System.out.println("treeNode1 maxDepth = " + maxDepth(treeNode1));// treeNode1 maxDepth = 3
    }

    //https://leetcode.cn/problems/maximum-depth-of-binary-tree/solution/hua-jie-suan-fa-104-er-cha-shu-de-zui-da-shen-du-b/

    /*
    * 解题思路
标签：DFS
找出终止条件：当前节点为空
找出返回值：节点为空时说明高度为 0，所以返回 0，节点不为空时则分别求左右子树的高度的最大值，同时加 1 表示当前节点的高度，
返回该数值

时间复杂度：O(n)
    * */
    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

}
