package BinaryTreeAndHeap;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 输入：root = [2,1,3]
 * 输出：true
 *               2
 *             1   3
 *
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *             5
 *          1     4
 *              3   6
 *
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println("treeNode isValidBST = " + isValidBST(treeNode));// true
        TreeNode treeNode1 = new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        System.out.println("treeNode1 isValidBST = " + isValidBST(treeNode1));// false
    }
    
    // https://leetcode.cn/problems/validate-binary-search-tree/solution/zhong-xu-bian-li-qing-song-na-xia-bi-xu-miao-dong-/
    static long pre = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }


}
