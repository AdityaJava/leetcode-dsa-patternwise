package P3FastAndSlowPointers.Q1LinkedListCycle;

import P3FastAndSlowPointers.ListNode;

public class LinkedListCycle {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    boolean cycleExists = false;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycleExists = true;
        break;
      }
    }
    if (cycleExists) {
      fast = head;
      while (fast != slow) {
        fast = fast.next;
        slow = slow.next;
      }
      return slow;
    }
    return null;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node2; // Connect last node to 2nd node to form a cycle

    //    ListNode node1 = new ListNode(1);
    //    ListNode node2 = new ListNode(2);
    //    node1.next = node2;
    //    node2.next = node1;

    //    ListNode node1 = new ListNode(1);
    //    ListNode node2 = new ListNode(2);
    //
    //    node1.next = node2;
    //    node2.next = node1;

    LinkedListCycle linkedListCycle = new LinkedListCycle();
    System.out.println(linkedListCycle.detectCycle(node1));
  }
}
