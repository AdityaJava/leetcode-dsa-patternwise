package P8HeapORPriorityQueue.heapify;

import java.util.Arrays;

public class Heapify {

    private void heapifyToMaxHeap(int[] arr, int index) {
        int largestIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < arr.length && arr[leftChildIndex] > arr[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < arr.length && arr[rightChildIndex] > arr[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(arr, index, largestIndex);
            heapifyToMaxHeap(arr, largestIndex);
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 30, 40, 50, 100, 25, 45, 60};
        Heapify heapify = new Heapify();
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify.heapifyToMaxHeap(arr, i);
        }
        Arrays.stream(arr).forEach(e -> System.out.print(e + ", "));
    }

}
