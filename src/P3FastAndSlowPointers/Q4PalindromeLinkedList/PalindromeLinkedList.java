package P3FastAndSlowPointers.Q4PalindromeLinkedList;

import P3FastAndSlowPointers.ListNode;

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head.next == null) {
      return true;
    }
    if (head.next.next == null) {
      return head.val == head.next.val;
    }
    ListNode mid = getStartOfSecondHalfOfLinkedList(head);
    reverseSecondHalf(mid);
    ListNode temp = mid.next;
    ListNode start = head;
    while (temp != null) {
      if (start.val != temp.val) {
        return false;
      }
      start = start.next;
      temp = temp.next;
    }
    return true;
  }

  private ListNode getStartOfSecondHalfOfLinkedList(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private void reverseSecondHalf(ListNode previous) {
    ListNode dummy = null;
    ListNode current = previous.next;
    ListNode next = current.next;
    while (current != null) {
      current.next = dummy;
      dummy = current;
      current = next;
      if (next != null) {
        next = next.next;
      }
    }
    previous.next = dummy;
  }

  public static void main(String[] args) {
    //    ListNode listNode1 = new ListNode(1);
    //    ListNode listNode2 = new ListNode(2);
    //    ListNode listNode3 = new ListNode(3);
    //    ListNode listNode4 = new ListNode(4);
    //    ListNode listNode5 = new ListNode(5);
    //    listNode1.next = listNode2;
    //    listNode2.next = listNode3;
    //    listNode3.next = listNode4;
    //    listNode4.next = listNode5;

    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(1);
    ListNode listNode3 = new ListNode(2);
    ListNode listNode4 = new ListNode(1);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = null;

    PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
    System.out.println(palindromeLinkedList.isPalindrome(listNode1));
  }
}
