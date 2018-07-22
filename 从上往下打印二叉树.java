�������´�ӡ������


# 1 ��Ŀ���� #
---

�������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��

<br/>

# 2 ˼· #
---

�������Ĳ������������һ����������ʵ�֡�

<br/>

# 3 ����ʵ�� #
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