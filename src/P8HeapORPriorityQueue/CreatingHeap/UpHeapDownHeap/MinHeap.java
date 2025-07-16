package P8HeapORPriorityQueue.CreatingHeap.UpHeapDownHeap;

public class MinHeap {
  private int[] heap;
  private int size;
  private int capacity;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.heap = new int[capacity];
  }

  public void insert(int val) {
    if (size >= capacity) {
      System.out.println("Heap is full");
      return;
    }
    heap[size] = val;
    upHeap(size);
    size++;
  }

  //This is alternative for heapify when we want to create heap with elements one by one
  private void upHeap(int i) {
    int parent = (i - 1) / 2;
    while (i > 0 && heap[i] < heap[parent]) {
      swap(i, parent);
      i = parent;
      parent = (i - 1) / 2;
    }
  }

  public int removeMin() {
    if (size == 0) {
      System.out.println("Heap is empty");
      return -1;
    }
    int min = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapify(0);
    return min;
  }

  //This is downHeap and is same as heapify
  private void heapify(int index) {
    int smallest = index;
    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;

    if (leftChildIndex < size && heap[leftChildIndex] < heap[smallest]) {
      smallest = leftChildIndex;
    }

    if (rightChildIndex < size && heap[rightChildIndex] < heap[smallest]) {
      smallest = rightChildIndex;
    }

    if (smallest != index) {
      swap(smallest, index);
      heapify(smallest);
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
    MinHeap heap = new MinHeap(10);
    heap.insert(5);
    heap.insert(3);
    heap.insert(8);
    heap.insert(1);
    heap.insert(6);

    heap.printHeap(); // Output: 1 3 8 5 6

    System.out.println("Removed min: " + heap.removeMin()); // 1
    heap.printHeap(); // Output: 3 5 8 6
  }
}
