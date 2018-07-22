从上往下打印二叉树


# 1 题目描述 #
---

从上往下打印出二叉树的每个节点，同层节点从左至右打印。

<br/>

# 2 思路 #
---

二叉树的层序遍历，借助一个辅助队列实现。

<br/>

# 3 代码实现 #
---

```
import java.util.ArrayList;
import java.util.LinkedList;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer>  resultList = new ArrayList<Integer>();
        if (root == null) {
            return resultList;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while (queue.size() != 0) {
            TreeNode pNode = queue.poll();
            resultList.add(pNode.val);
            if (pNode.left != null) {
                queue.add(pNode.left);
            }
            if (pNode.right != null) {
                queue.add(pNode.right);
            }
        }
        
        return resultList;
    }
}
```

<br/>