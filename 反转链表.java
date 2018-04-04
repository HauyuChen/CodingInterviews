反转链表

题目描述
输入一个链表，反转链表后，输出链表的所有元素。

思路：
1. 反转链表可以通过栈作为辅助数组，先将链表节点全部入栈，然后逐个出栈重新构造链表，但这样会占用额外的空间；
2. 不需要辅助空间的解法是直接翻转相邻节点的指针，通过三个指针分别指向前一节点、当前节点、下一节点，但这会改变原有链表的结构。
因此，采用何种思路应考虑具体要求。


/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p = head;
        ListNode q = p.next;
        ListNode r = null;
        head.next = null;
        
        while(q!=null){
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        return p;
    }
}