package P8HeapORPriorityQueue.MergeKSortedlists;

import java.util.List;

import P3FastAndSlowPointers.ListNode;

class MinHeap {
  int capacity;
  int size = 0;
  ListNode[] heap;

  public MinHeap(int capacity) {
    this.capacity = capacity;
  }

  public void insert(ListNode node, int nodeIndex) {
    int tempIndex = nodeIndex;
    int parentIndex = (tempIndex - 1) / 2;
    ListNode parent = heap[parentIndex];
    while (parent.val > node.val) {
      swap(tempIndex, parentIndex);
      tempIndex = parentIndex;
      parentIndex = (tempIndex + 1) / 2;
      parent = heap[parentIndex];
    }
    size++;
  }

  public void delete() {
    swap(0, size);
    size--;
    heapify(0);
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

}

public class MergeKSortedlists {
  public ListNode mergeKLists(ListNode[] lists) {

  }

}
