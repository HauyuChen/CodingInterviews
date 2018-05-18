合并两个排序的链表


# 1 题目描述 #
---

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

<br/>

# 2 思路 #
---

合并两个排序的链表，通过递归实现。

<br/>

# 3 代码实现 #
---

```
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        
        ListNode retHead = null;
        if(list1.val<list2.val){
            retHead = list1;
            retHead.next = Merge(list1.next,list2);
        }
        else{
            retHead = list2;
            retHead.next = Merge(list1,list2.next);
        }
        
        return retHead;
    }
}
```

<br/>