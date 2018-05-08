从尾到头打印链表


# 1 题目描述 #
---

输入一个链表，从尾到头打印链表每个节点的值。

<br/>

# 2 思路 #
---

链表顺便遍历，并存入 ArrayList 中；反转 ArrayList 并返回结果。

<br/>

# 3 代码实现 #
---

```
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Collections; 

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {  
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        
        return list;
    }
}
```

<br/>