平衡二叉树



题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。



思路：
本题一个简单的思路可以分别计算左右子树的深度，然后判断是否平衡。但是这样会造成重复的计算。
这里，采用了后序遍历的思路，避免重复计算子树的深度。这里我做了一个小改动，isBalance方法返回-1时表示该二叉树不平衡，返回其它值则表示该二叉树的深度。


public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        if(isBalance(root)==-1){
            return false;
        }
        return true;
    }
    
    private int isBalance(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = isBalance(root.left);
        int right = isBalance(root.right);
        if(left!=-1 && right!=-1){
            int diff = left-right;
            if(diff>=-1&&diff<=1){
                return 1 + (left>right?left:right);
            }
        }
        return -1;
    }
}
