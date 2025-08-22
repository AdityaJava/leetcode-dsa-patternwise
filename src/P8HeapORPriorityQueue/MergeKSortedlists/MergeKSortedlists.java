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

  //  public void insert(ListNode node) {
  //    if (size < capacity) {
  //      insert(node, size++);
  //    }
  //    else {
  //
  //    }
  //  }

  public void insert(ListNode node, int nodeIndex) {
    heap[size] = node;
    int tempIndex = nodeIndex;
    int parentIndex = (tempIndex - 1) / 2;
    ListNode parent = heap[parentIndex];
    while (tempIndex != 0 && parent.val > node.val) {
      swap(tempIndex, parentIndex);
      tempIndex = parentIndex;
      parentIndex = (tempIndex + 1) / 2;
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
    ListNode temp = null;
    ListNode head = null;
    MinHeap minHeap = new MinHeap(lists.length);
    int i = 0;
    for (ListNode node : lists) {
      minHeap.insert(node, i);
      i++;
    }
    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.delete();
      if (head == null) {
        temp = node;
        head = node;
      }
      else {
        temp.next = node;
        temp = temp.next;
      }
      i--;
      if (node.next != null) {
        minHeap.insert(node.next, i);
        i++;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));

    // Second linked list: 1 -> 3 -> 4
    ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

    // Third linked list: 2 -> 6
    ListNode l3 = new ListNode(2, new ListNode(6));

    // Put them in an array for processing
    ListNode[] lists = new ListNode[] { l1, l2, l3 };

    MergeKSortedlists mergeKSortedlists = new MergeKSortedlists();
    ListNode node = mergeKSortedlists.mergeKLists(lists);

    while (node.next != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }

}
