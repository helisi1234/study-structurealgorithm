package leetcode.list;

import java.util.List;

/*
*  203.链表中删除所有value
*  public class ListNode {
*    int val;
*    ListNode next;
*    ListNode(int x) { val = x; }
*  }
* */
public class DeleteElement {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
   }

   /*
   *  给出链表头节点和要删除的value，删除链表中所有值是value的节点
   *  没有dummyhead的情况
   * */
   public ListNode removeElements(ListNode head, int val) {
       /*
       *  从头节点开始判断
       *  1.节点不为null && 节点的值是val
       *      正常的删除操作
       *  2.从头节点开始要一直判断直到第一个值不是val的节点
       *      采用循环
       * */
       while(head != null && head.val == val) {
           ListNode delNode = head;
           head = head.next;
           delNode.next = null;
       }
       /*
       *  如果整个链表的节点的值都是给定的val那么直接返回
       *  此时return head;和return null;是相同的
       * */
       if(head == null) {
           return head;
       }
       /*
       *  当链表此时的头节点的值不是val，就要删除链表中间值为val的节点，同理也是循环
       *  1.判断当前节点的下一个节点不为null，防止遍历到尾节点导致空指针异常
       *  2.使用prev指向需要删除节点的前一个节点。当prev.next是需要删除的节点时，进
       *    行删除操作。此时不能移动prev的位置需要继续判断此时的prev.next即原来的
       *    prev.next.next这个节点的值是否是val。
       * */
       ListNode prev = head;
       while(prev.next != null) {
           if(prev.next.val == val) {
               ListNode delNode = prev.next;
               prev.next = delNode.next;
               delNode.next = null;
           } else {
               prev = prev.next;
           }
       }
//       删除完成后返回链表头节点
       return head;
   }

//   使用dummyhead
    public ListNode removeElements_2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode recursionRemoveElements(ListNode head, int val) {
       if(head == null) {
           return null;
       }
       ListNode res = recursionRemoveElements(head.next, val);
       if(head.val == val) {
           return res;
       } else {
           head.next = res;
           return head;
       }
    }
}





















