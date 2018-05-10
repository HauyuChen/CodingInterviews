二叉树的镜像


# 1 题目描述 #
---

操作给定的二叉树，将其变换为源二叉树的镜像。

输入描述:

二叉树的镜像定义：源二叉树 

```
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
```

<br/>

# 2 思路 #
---

1. 如果 root 不是叶子节点，则交换左右子树；
2. 如果左右子树非空，则对左右子树递归调用 Mirror 。

<br/>

# 3 代码实现 #
---

```
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public void Mirror(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return ;
        }
        
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        
        if(root.left!=null){
            Mirror(root.left);
        }
        if(root.right!=null){
            Mirror(root.right);
        }
    }
}
```

<br/>
