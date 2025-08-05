package P8HeapORPriorityQueue.KthLargestElementInArray;

/**
 * Build heap from full array at once	heapify()	You have all data upfront
 * Insert/delete elements one at a time	upHeap / downHeap	You build heap dynamically
 */

/**
 * 🧠 The Goal:
 * We want to find the Kth largest element.
 * To do that, we maintain a min-heap of size k.
 * That means:
 *
 * The smallest of the top k largest elements will be at heap[0].
 */
public class KthLargestElementInArray {

  public int findKthLargest(int[] nums, int k) {
    int[] heap = new int[k];
    int heapSize = 0;
    for (int i = 0; i < nums.length; i++) {
      if (heapSize < heap.length) {
        insertInHeap(heap, heapSize, nums[i]);
        heapSize++;
      }
      // Any time we see a number larger than heap[0] (Smallest among all elements in heap), it should replace the root.
      else if (nums[i] > heap[0]) {
        // Only replace root if nums[i] is bigger than the smallest (heap[0])
        deleteFromHeap(heap, heapSize - 1);
        insertInHeap(heap, heapSize - 1, nums[i]);
      }
    }
    return heap[0];
  }

  // Why use a Min Heap instead of a Max Heap?
  // If we use a Max Heap of size k, the top element is the largest among the k elements,
  // which does not represent the k-th largest overall.
  // With a Min Heap of size k, the top element is the smallest among the k largest elements found so far,
  // which is exactly the k-th largest element.
  private void insertInHeap(int[] heap, int heapSize, int element) {
    heap[heapSize] = element;
    int temp = heapSize;
    int parent = (temp - 1) / 2;
    while (temp > 0 && heap[parent] > heap[temp]) {
      swap(heap, parent, temp);
      temp = parent;
      parent = (temp - 1) / 2;
    }
  }

  private void deleteFromHeap(int[] heap, int heapSize) {
    swap(heap, 0, heapSize);
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
    //    int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    //    int k = 4;

    int[] nums = { 3, 2, 1, 5, 6, 4 };
    int k = 2;

    KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
    System.out.println(kthLargestElementInArray.findKthLargest(nums, k));
  }

}
