package BinaryTreeAndHeap;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * https://leetcode.cn/problems/invert-binary-tree/
 *
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        //打断点可查看 TreeNode
        invertTree(treeNode);//treeNode 由 [2,1,3] 翻转成 [2,3,1]
        invertTree1(treeNode);// 由 [2,3,1] 翻转成 [2,1,3]
    }

    public static TreeNode invertTree(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        invertTree(root.left);
        //递归交换当前节点的 右子树
        invertTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

    // https://leetcode.cn/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/961128
    public static TreeNode invertTree1(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree1(root.right);
        root.right = invertTree1(temp);
        return root;
    }

}
