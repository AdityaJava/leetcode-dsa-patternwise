package P8HeapORPriorityQueue.CreatingHeap.UpHeapDownHeap;

public class MaxHeap {
  int[] heap;
  int capacity;
  int size;

  public MaxHeap(int capacity) {
    heap = new int[capacity];
    this.capacity = capacity;
  }

  public void insert(int i) {
    if (size == capacity) {
      System.out.println("Heap is full");
      return;
    }
    heap[size] = i;
    upheap(size);
    size++;
  }

  // Note: This method also builds a heap, similar to heapify, but with a key difference:
  // Heapify requires the entire array at the start and cannot build the heap incrementally.
  // The time complexity here is O(n log n): each insertion may take up to log n swaps, and there are n insertions.

  // WHat this method does?
  //The `upheap` method moves a newly added element up the heap until the max-heap property is restored.
  //**Example:** If you insert 8 into a heap `[5, 3]`, `upheap` will move 8 to the top, resulting in `[8, 3, 5]`.
  private void upheap(int index) {
    int parent = (index - 1) / 2;
    while (index > 0 && heap[index] > heap[parent]) {
      swap(index, parent);
      index = parent;
      parent = (index - 1) / 2;
    }
  }

  private int removeMax() {
    if (size == 0) {
      System.out.println("Heap is empty");
      return -1;
    }
    int max = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapify(0);
    return max;
  }

  //This is also called as Down Heap as this goes down to the tree
  private void heapify(int index) {
    int largest = index;
    int leftChild = 2 * index + 1;
    int rightChild = 2 * index + 2;

    if (leftChild < size && heap[largest] < heap[leftChild]) {
      largest = leftChild;
    }

    if (rightChild < size && heap[largest] < heap[rightChild]) {
      largest = rightChild;
    }

    if (largest != index) {
      swap(index, largest);
      heapify(largest);
    }

  }

  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }


  public void printHeap() {
    for (int i = 0; i < size; i++) {
      System.out.print(heap[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    MaxHeap heap = new MaxHeap(10);
    heap.insert(5);
    heap.insert(3);
    heap.insert(8);
    heap.insert(1);
    heap.insert(6);
    heap.printHeap();

    heap.removeMax();
    heap.printHeap();
  }

}
