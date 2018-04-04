二叉树的下一个结点


# 1 题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

<br/>

# 2 思路
主要有三种情况，建议先画出一棵二叉树帮助理解。
1. 节点有右子树：找右子树的最左子节点；
2. 节点是父节点的左节点：找父节点；
3. 节点是父节点的右节点：找其父节点，且改父节点为父父节点的左孩子。

<br/>

# 3 代码实现

```
/*
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        if(pNode.right!=null){
            TreeLinkNode node = pNode.right;
            while(node.left!=null){
                node = node.left;
            }
            return node;
        }
        else{
            TreeLinkNode father = pNode.next;
            while(father!=null&&father.right==pNode){
                pNode = father;
                father = father.next;
            }
            return father;
        }
    }
}
```
