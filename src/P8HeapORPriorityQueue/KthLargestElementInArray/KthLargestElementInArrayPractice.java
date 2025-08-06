package P8HeapORPriorityQueue.KthLargestElementInArray;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElementInArrayPractice {

  public int findKthLargest(int[] nums, int k) {
    int[] heap = new int[k];
    int size = 0;
    int capacity = k;
    for (int i = 0; i < nums.length; i++) {
      if (size < capacity) {
        insertInMinHeap(heap, size, nums[i]);
        size++;
      }
      else {
        if (nums[i] > heap[0]) {
          deleteFromHeap(heap, size - 1);
          insertInMinHeap(heap, size - 1, nums[i]);
        }
      }
    }
    return heap[0];
  }

  // Why use a Min Heap instead of a Max Heap?
  // If we use a Max Heap of size k, the top element is the largest among the k elements,
  // which does not represent the k-th largest overall.
  // With a Min Heap of size k, the top element is the smallest among the k largest elements found so far,
  // which is exactly the k-th largest element.
  private void insertInMinHeap(int[] heap, int size, int num) {
    heap[size] = num;
    int temp = size;
    int parent = (temp - 1) / 2;
    while (temp > 0 && heap[parent] > heap[temp]) {
      swap(heap, temp, parent);
      temp = parent;
      parent = (temp - 1) / 2;
    }
  }

  private void swap(int[] heap, int position1, int position2) {
    int temp = heap[position1];
    heap[position1] = heap[position2];
    heap[position2] = temp;
  }

  private void deleteFromHeap(int[] heap, int size) {
    swap(heap, 0, size);
    heapify(heap, size, 0);
  }

  private void heapify(int[] heap, int size, int parentIndex) {
    int leftChildIndex = 2 * parentIndex + 1;
    int rightChildIndex = 2 * parentIndex + 2;
    int smallestElementIndex = parentIndex;

    if (leftChildIndex < size && heap[leftChildIndex] < heap[smallestElementIndex]) {
      smallestElementIndex = leftChildIndex;
    }

    if (rightChildIndex < size && heap[rightChildIndex] < heap[smallestElementIndex]) {
      smallestElementIndex = rightChildIndex;
    }

    if (smallestElementIndex != parentIndex) {
      swap(heap, smallestElementIndex, parentIndex);
      heapify(heap, size, smallestElementIndex);
    }
  }


  public static void main(String[] args) {
    int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k = 4;
    KthLargestElementInArrayPractice kthLargestElementInArrayPractice = new KthLargestElementInArrayPractice();
    System.out.println(kthLargestElementInArrayPractice.findKthLargest(nums, k));
  }
}
