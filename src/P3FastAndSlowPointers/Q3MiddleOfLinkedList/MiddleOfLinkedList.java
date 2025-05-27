package P3FastAndSlowPointers.Q3MiddleOfLinkedList;

import P3FastAndSlowPointers.ListNode;

public class MiddleOfLinkedList {
  public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String[] args) {

  }
}
