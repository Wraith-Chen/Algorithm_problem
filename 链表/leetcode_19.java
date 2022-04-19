package 链表;

/**
 * @Time 2022-4-19
 * @Title leetcode_19 删除链表的倒数第N个节点
 * @Difficulty_Level middle
 */
/*
    双指针，设置两个快慢指针。快指针先走n个位置后，慢指针开始走，当快指针到达尾节点，慢指针所只指向的下一个即是待删除的节点。
 */
public class leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if(head == null||head.next==null){
        //     return null;
        // }
        ListNode pre = new ListNode(0,head);
        ListNode slow = pre,fast = head;
        for(int i = 0;i<n;i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        ListNode N = pre.next;
        return N;
    }
}
