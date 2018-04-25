重建二叉树

# 1 题目描述
---

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

<br/>

# 2 思路
---

这是一道比较经典的题目，通过前序和中序构造二叉树。
根据前序遍历的性质，第一个元素为根节点；
然后在中序序列中找到该元素，其左边的元素即为根结点的左子树，其右边的元素即为根节点的右子树；
递归即可。

<br/>

# 3 代码实现（Java）
---

```
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null||pre.length!=in.length){
            return null;
        }
        
        return construct(pre,0,pre.length-1,in,0,in.length-1);
    }
    
    private static TreeNode construct(int[] pre,int pre_left,int pre_right,int[] in,int in_left,int in_right){
        if(pre_right<pre_left||in_right<in_left){
            return null;
        }
        
        TreeNode tNode = new TreeNode(pre[pre_left]);
        int pivot = 0;
        
        for(int i=in_left;i<=in_right;i++){
            if(in[i]==pre[pre_left]){
                pivot = i;
            }
        }

        tNode.left = construct(pre,pre_left+1,pre_left+(pivot-in_left),in,in_left,pivot-1);
        tNode.right = construct(pre,pre_left+(pivot-in_left)+1,pre_right,in,pivot+1,in_right);
       
        return tNode;
    }
}
```

<br/>