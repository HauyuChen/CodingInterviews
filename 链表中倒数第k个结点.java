链表中倒数第k个结点


# 1 题目描述 #
---

输入一个链表，输出该链表中倒数第 k 个结点。

<br/>

# 2 思路 #
---

通过两个指针一前一后走，一个指针先走 k-1 步。这题重要在于对程序鲁棒性的考虑，注意考虑输入链表为空、 k 大于链表的总长度、 k 小于 1 的情况。

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
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<1){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        
        for(int i=0;i<k-1;i++){
            if(p2.next==null){
                return null;
            }
            p2 = p2.next;
        }
        
        while(p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
```

<br/>
