package P8HeapORPriorityQueue.TopKFrequentElements;


import java.util.Arrays;

class MinHeap {
  int capacity;
  int size;
  int[] minHeap;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.minHeap = new int[capacity];
    size = 0;
  }

  public void insert(int num) {
    if (size < capacity) {
      insertInHeap(num);
    }
    else {
      if (minHeap[0] < num) {
        delete();
        insertInHeap(num);
      }
    }
  }

  private void insertInHeap(int num) {
    minHeap[size] = num;
    int tempPosition = size;
    int parent = (tempPosition - 1) / 2;
    while (tempPosition != 0 && minHeap[parent] > minHeap[tempPosition]) {
      swap(tempPosition, parent);
      tempPosition = parent;
      parent = (tempPosition - 1) / 2;
    }
    size++;
  }

  private void delete() {
    size--;
    swap(0, size);
    heapify(0);
  }

  private void heapify(int index) {
    int leftChildIndex = (2 * index) + 1;
    int rightChildIndex = (2 * index) + 2;
    int smallestElementIndex = index;

    if (leftChildIndex < size && minHeap[smallestElementIndex] > minHeap[leftChildIndex]) {
      smallestElementIndex = leftChildIndex;
    }
    if (rightChildIndex < size && minHeap[smallestElementIndex] > minHeap[rightChildIndex]) {
      smallestElementIndex = rightChildIndex;
    }
    if (smallestElementIndex != index) {
      swap(smallestElementIndex, index);
      heapify(smallestElementIndex);
    }
  }

  private void swap(int i, int j) {
    int temp = minHeap[i];
    minHeap[i] = minHeap[j];
    minHeap[j] = temp;
  }

  public void print() {
    Arrays.stream(minHeap).forEach(System.out::println);
  }
}

public class TopKFrequentElements {

  //  public int[] topKFrequent(int[] nums, int k) {
  //
  //  }


  public static void main(String[] args) {
    int k = 4;
    MinHeap minHeap = new MinHeap(k);
    int[] nums = { 10, 8, 6, 4, 5, 3 };
    for (int num : nums) {
      minHeap.insert(num);
    }
    minHeap.print();
  }
}
