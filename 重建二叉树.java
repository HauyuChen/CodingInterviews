�ؽ�������

# 1 ��Ŀ����
---

����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡���������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�

<br/>

# 2 ˼·
---

����һ���ȽϾ������Ŀ��ͨ��ǰ����������������
����ǰ����������ʣ���һ��Ԫ��Ϊ���ڵ㣻
Ȼ���������������ҵ���Ԫ�أ�����ߵ�Ԫ�ؼ�Ϊ�����������������ұߵ�Ԫ�ؼ�Ϊ���ڵ����������
�ݹ鼴�ɡ�

<br/>

# 3 ����ʵ�֣�Java��
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