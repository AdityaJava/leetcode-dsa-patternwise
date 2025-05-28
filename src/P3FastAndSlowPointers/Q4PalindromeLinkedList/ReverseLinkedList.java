package P3FastAndSlowPointers.Q4PalindromeLinkedList;

import P3FastAndSlowPointers.ListNode;

public class ReverseLinkedList {

  private ListNode reverseLinkedList(ListNode head) {
    ListNode previous = null;
    ListNode current = head;
    ListNode next = head.next;
    while (current != null) {
      current.next = previous;
      previous = current;
      current = next;
      if (next != null) {
        next = next.next;
      }
    }
    return previous;
  }

  private void print(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.println(temp.val);
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    reverseLinkedList.print(head);
    System.out.println("...");
    head = reverseLinkedList.reverseLinkedList(head);
    reverseLinkedList.print(head);
  }
}
