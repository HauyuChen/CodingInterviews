��ת����

��Ŀ����
����һ��������ת�����������������Ԫ�ء�

˼·��
1. ��ת�������ͨ��ջ��Ϊ�������飬�Ƚ�����ڵ�ȫ����ջ��Ȼ�������ջ���¹���������������ռ�ö���Ŀռ䣻
2. ����Ҫ�����ռ�Ľⷨ��ֱ�ӷ�ת���ڽڵ��ָ�룬ͨ������ָ��ֱ�ָ��ǰһ�ڵ㡢��ǰ�ڵ㡢��һ�ڵ㣬�����ı�ԭ������Ľṹ��
��ˣ����ú���˼·Ӧ���Ǿ���Ҫ��


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