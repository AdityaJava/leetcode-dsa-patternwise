package P8HeapORPriorityQueue.KthLargestElementInArray;

/**
 * Build heap from full array at once	heapify()	You have all data upfront
 * Insert/delete elements one at a time	upHeap / downHeap	You build heap dynamically
 */
public class KthLargestElementInArray {

  public int findKthLargest(int[] nums, int k) {
    int[] heap = new int[k];
    int heapSize = 0;
    for (int i = 0; i < nums.length; i++) {
      insertInHeap(heap, heapSize, nums[i]);
      heapSize++;
    }
    return heap[0];
  }

  private void insertInHeap(int[] heap, int heapSize, int element) {
    if (heapSize == 0) {
      heap[heapSize] = element;
      return;
    }
    if (heapSize == heap.length) {
      deleteFromHeap(heap, heapSize);
    }
    heap[heapSize] = element;
    int temp = heapSize;
    int parent = (temp - 1) / 2;
    while (heap[parent] > heap[temp]) {
      swap(heap, parent, temp);
      temp = parent;
      parent = (temp - 1) / 2;
    }
  }

  private void deleteFromHeap(int[] heap, int heapSize) {
    swap(heap, 0, heapSize);
    heapSize--;
    heapify(heap, heapSize, 0);
  }

  private void heapify(int[] heap, int heapSize, int index) {
    int smallest = index;
    int leftChildIndex = index * 2 + 1;
    int rightChildIndex = index * 2 + 2;

    if (leftChildIndex < heapSize && heap[leftChildIndex] < heap[smallest]) {
      smallest = leftChildIndex;
    }

    if (rightChildIndex < heapSize && heap[rightChildIndex] < heap[smallest]) {
      smallest = rightChildIndex;
    }

    if (smallest != index) {
      swap(heap, smallest, index);
      heapify(heap, heapSize, smallest);
    }
  }

  private void swap(int[] heap, int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k = 4;
    KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
    System.out.println(kthLargestElementInArray.findKthLargest(nums, k));
  }

}
