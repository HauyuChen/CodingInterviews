二叉搜索树的后序遍历序列


# 1 题目描述 #
---

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

<br/>

# 2 思路 #
---

本题应结合搜索二叉树后序遍历的特性，其后序遍历序列最后一个节点为根节点，且前面的节点分为两部分，左边的都比根节点小，右边的都比根节点大。

基于这个特性，只需判断序列中除最后一个节点外是否满足前半部分都比最后一个节点小，后半部分都比根节点大即可。

<br/>

# 3 代码实现 #
---

```
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        
        return isSquenceOfBST(sequence,0,sequence.length-1);
    }
    
    private boolean isSquenceOfBST(int[] seq, int low, int high) {
        if (low >= high) {
            return true;
        }
        
        int index = 0;
        int pivot;
        
        while (seq[index] < seq[high] && index < high) {
            index++;
        }
        pivot = index;
        while (seq[index] > seq[high] && index < high) {
            index++;
        }
        if (index == high) {
            return isSquenceOfBST(seq,low,pivot-1) && isSquenceOfBST(seq,pivot,high-1);
        } else {
            return false;
        }
    }
}
```

<br/>