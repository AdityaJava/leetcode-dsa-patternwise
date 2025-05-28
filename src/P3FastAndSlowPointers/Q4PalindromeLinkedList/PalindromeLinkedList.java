package P3FastAndSlowPointers.Q4PalindromeLinkedList;

import P3FastAndSlowPointers.ListNode;

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    ListNode previous = getStartOfSecondHalfOfLinkedList(head);
  }

  private ListNode getStartOfSecondHalfOfLinkedList(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseSecondHalf(ListNode previous) {
    ListNode current = previous.next;
    ListNode next = current.next;

  }

  public static void main(String[] args) {

  }
}
