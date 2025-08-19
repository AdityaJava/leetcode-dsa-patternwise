package P8HeapORPriorityQueue.TopKFrequentElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class MinHeapClass {
  int capacity;
  int size;
  Entry[] minHeap;

  static class Entry {
    int num;
    long frequency;

    public Entry(int num, long frequency) {
      this.num = num;
      this.frequency = frequency;
    }
  }

  public MinHeapClass(int capacity) {
    this.capacity = capacity;
    this.minHeap = new Entry[capacity];
    size = 0;
  }

  public void insert(Entry num) {
    if (size < capacity) {
      insertInHeap(num);
    }
    else {
      if (minHeap[0].frequency < num.frequency) {
        delete();
        insertInHeap(num);
      }
    }
  }

  private void insertInHeap(Entry num) {
    minHeap[size] = num;
    int tempPosition = size;
    int parent = (tempPosition - 1) / 2;
    while (tempPosition != 0 && minHeap[parent].frequency > minHeap[tempPosition].frequency) {
      swap(
        tempPosition,
        parent
      );
      tempPosition = parent;
      parent = (tempPosition - 1) / 2;
    }
    size++;
  }

  public void delete() {
    size--;
    swap(
      0,
      size
    );
    heapify(0);
  }

  private void heapify(int index) {
    int leftChildIndex = (2 * index) + 1;
    int rightChildIndex = (2 * index) + 2;
    int smallestElementIndex = index;

    if (leftChildIndex < size && minHeap[smallestElementIndex].frequency > minHeap[leftChildIndex].frequency) {
      smallestElementIndex = leftChildIndex;
    }
    if (rightChildIndex < size && minHeap[smallestElementIndex].frequency > minHeap[rightChildIndex].frequency) {
      smallestElementIndex = rightChildIndex;
    }
    if (smallestElementIndex != index) {
      swap(
        smallestElementIndex,
        index
      );
      heapify(smallestElementIndex);
    }
  }

  private void swap(int i, int j) {
    Entry temp = minHeap[i];
    minHeap[i] = minHeap[j];
    minHeap[j] = temp;
  }

  public void print() {
    Arrays.stream(minHeap).forEach(System.out::println);
  }
}

public class TopKFrequentElements {

  public int[] topKFrequent(int[] nums, int k) {
    MinHeapClass minHeapClass = new MinHeapClass(k);
    List<MinHeapClass.Entry> entryList = getEntryList(nums);
    int size = 0;
    for (int i = 0; i < entryList.size(); i++) {
      if (size < minHeapClass.capacity) {
        minHeapClass.insert(entryList.get(i));
      }
      else {
        if (minHeapClass.minHeap[0].frequency < entryList.get(i).frequency) {
          minHeapClass.delete();
          minHeapClass.insert(entryList.get(i));
        }
      }
    }
  }

  private List<MinHeapClass.Entry> getEntryList(int[] nums) {
    Map<Integer, Long> numToFrequency = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(
      Function.identity(),
      Collectors.counting()
    ));
    List<MinHeapClass.Entry> entryList = new ArrayList<>();
    for (Map.Entry<Integer, Long> entry : numToFrequency.entrySet()) {
      entryList.add(new MinHeapClass.Entry(
        entry.getKey(),
        entry.getValue()
      ));
    }
    return entryList;
  }

  public static void main(String[] args) {
    int k = 4;
    MinHeapClass minHeapClass = new MinHeapClass(k);
    int[] nums = { 10, 8, 6, 4, 5, 3 };
    for (int num : nums) {
      minHeapClass.insert(num);
    }
    minHeapClass.print();
  }
}
