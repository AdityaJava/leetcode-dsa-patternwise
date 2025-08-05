package P8HeapORPriorityQueue.KthLargestElementInArray;

public class KthLargestElementInArrayPractice {
  int[] heap;
  int size;
  int capacity;

  public int findKthLargest(int[] nums, int k) {
    heap = new int[k];
    capacity = k;
  }

  // Why use a Min Heap instead of a Max Heap?
  // If we use a Max Heap of size k, the top element is the largest among the k elements,
  // which does not represent the k-th largest overall.
  // With a Min Heap of size k, the top element is the smallest among the k largest elements found so far,
  // which is exactly the k-th largest element.
  private void insertInMinHeap(int num) {

  }


  public static void main(String[] args) {

  }
}
