package P8HeapORPriorityQueue.MergeKSortedlists;

import P3FastAndSlowPointers.ListNode;

class MinHeap {
  int capacity;
  int size = 0;
  ListNode[] heap;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    heap = new ListNode[capacity];
  }

  public void insert(ListNode node) {
    heap[size] = node;
    int tempIndex = size;
    int parentIndex = (tempIndex - 1) / 2;
    ListNode parent = heap[parentIndex];
    while (tempIndex != 0 && parent.val > node.val) {
      swap(tempIndex, parentIndex);
      tempIndex = parentIndex;
      parentIndex = (tempIndex - 1) / 2;
      parent = heap[parentIndex];
    }
    size++;
  }

  public ListNode delete() {
    size--;
    ListNode node = heap[0];
    swap(0, size);
    heapify(0);
    return node;
  }

  private void heapify(int index) {
    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;
    int smallestElementIndex = index;
    if (leftChildIndex < size && (heap[leftChildIndex].val < heap[smallestElementIndex].val)) {
      smallestElementIndex = leftChildIndex;
    }
    if (rightChildIndex < size && (heap[rightChildIndex].val < heap[smallestElementIndex].val)) {
      smallestElementIndex = rightChildIndex;
    }
    if (smallestElementIndex != index) {
      swap(smallestElementIndex, index);
      heapify(smallestElementIndex);
    }
  }

  private void swap(int index1, int index2) {
    ListNode t = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = t;
  }

  public boolean isEmpty() {
    return size <= 0;
  }

}

public class MergeKSortedlists {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null; // Case []
    }

    ListNode head = new ListNode(-99);
    ListNode temp = head;

    MinHeap minHeap = new MinHeap(lists.length);

    for (ListNode node : lists) {
      if (node != null) {
        minHeap.insert(node);
      }
    }
    if (minHeap.isEmpty()) {
      return null; // Case [[]]
    }

    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.delete();
      if (head.val == -99) {
        temp = node;
        head = node;
      }
      else {
        temp.next = node;
        temp = temp.next;
      }
      if (node.next != null) {
        minHeap.insert(node.next);
      }
    }
    return head;
  }

  public static void main(String[] args) {
    int[][] input = {
      { -8, -7, -7, -5, 1, 1, 3, 4 }, { -2 }, { -10, -10, -7, 0, 1, 3 }, { 2 }
    };

    // Convert each array into a linked list
    ListNode[] lists = new ListNode[input.length];
    for (int i = 0; i < input.length; i++) {
      lists[i] = createLinkedList(input[i]);
    }
    MergeKSortedlists mergeKSortedlists = new MergeKSortedlists();
    ListNode node = mergeKSortedlists.mergeKLists(lists);
    printList(node);
  }

  private static ListNode createLinkedList(int[] arr) {
    if (arr.length == 0) {
      return null;
    }

    ListNode head = new ListNode(arr[0]);
    ListNode current = head;

    for (int i = 1; i < arr.length; i++) {
      current.next = new ListNode(arr[i]);
      current = current.next;
    }
    return head;
  }

  private static void printList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val + " -> ");
      curr = curr.next;
    }
    System.out.println("null");
  }


}
