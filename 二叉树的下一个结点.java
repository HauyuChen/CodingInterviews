����������һ�����


# 1 ��Ŀ����
����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣

<br/>

# 2 ˼·
��Ҫ����������������Ȼ���һ�ö�����������⡣
1. �ڵ��������������������������ӽڵ㣻
2. �ڵ��Ǹ��ڵ����ڵ㣺�Ҹ��ڵ㣻
3. �ڵ��Ǹ��ڵ���ҽڵ㣺���丸�ڵ㣬�Ҹĸ��ڵ�Ϊ�����ڵ�����ӡ�

<br/>

# 3 ����ʵ��

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
