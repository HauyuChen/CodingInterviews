把二叉树打印成多行


# 1 题目描述 #
---

从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

<br/>

# 2 思路 #
---

本题实质上是二叉树的层序遍历。

<br/>

# 3 代码实现 #
---

```
import java.util.ArrayList;
import java.util.LinkedList;

/*
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
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> retList = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return retList;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        
        while (queue.size()!=0) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0;i < size;i++) {
                TreeNode tmp = queue.poll();
                row.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            retList.add(row);
        }
        return retList;
    }
}
```

<br/>