package 链表;
/**
 * @Time 2021-12-07
 * @Title leetcode_328 奇偶链表
 * @Difficulty_Level middle
 */
/*

 */
public class leetcode_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }//判空
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;//维护两个指针指向奇数和偶数节点
        while(even!=null&&even.next!=null){
            odd.next=even.next;
            //更新奇数节点，奇数节点的后一个节点需要指向偶数节点的后一个节点
            odd=odd.next;
            //然后移动奇数当前节点为更新节点

            even.next=odd.next;
            //根据上一个更新的奇数节点下一个则为偶数的后一个节点
            even=even.next;
            //移动偶数当前节点为更新节点
        }
        odd.next=evenHead;
        return head;
    }
}
