�����������ĺ����������


# 1 ��Ŀ���� #
---

����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ��������������Yes,�������No���������������������������ֶ�������ͬ��

<br/>

# 2 ˼· #
---

����Ӧ�������������������������ԣ����������������һ���ڵ�Ϊ���ڵ㣬��ǰ��Ľڵ��Ϊ�����֣���ߵĶ��ȸ��ڵ�С���ұߵĶ��ȸ��ڵ��

����������ԣ�ֻ���ж������г����һ���ڵ����Ƿ�����ǰ�벿�ֶ������һ���ڵ�С����벿�ֶ��ȸ��ڵ�󼴿ɡ�

<br/>

# 3 ����ʵ�� #
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