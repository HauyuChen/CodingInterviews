两个链表的第一个公共结点


# 1 题目描述 #
---

输入两个链表，找出它们的第一个公共结点。

<br/>

# 2 思路 #
---

1. 先分别求出两个链表的长度 len1 、 len2 ；
2. 长度较长的链表先走 |len1-len2| 步；
3. 接下来两个链表一起走，直到结点相同即为结果。

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
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if(pHead1==null || pHead2==null){
             return null;
         }
        
        ListNode tmpNode1 = pHead1;
        ListNode tmpNode2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while(tmpNode1!=null){
            len1++;
            tmpNode1 = tmpNode1.next;
        }
        while(tmpNode2!=null){
            len2++;
            tmpNode2 = tmpNode2.next;
        }
        
        if(len1>len2){
            for(int i=0;i<len1-len2;i++){
                pHead1 = pHead1.next;
            }
        }
        else{
            for(int i=0;i<len2-len1;i++){
                pHead2 = pHead2.next;
            }
        }
        while(pHead1!=null && pHead2!=null){
            if(pHead1.val==pHead2.val){
                return pHead1;
            }
            else{
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        
        return null;
    }
}
```

<br/>