package P8HeapORPriorityQueue.heapsort;

import java.util.Arrays;

// Note HeapSort is not stable meaning it doesn't maintain order if 2 elements are same
// Example

/**
 * Person[] arr = {
 * new Person("A", 25),
 * new Person("B", 30),
 * new Person("C", 25)
 * };
 * <p>
 * If the sort is stable, after sorting by age:
 * // Sorted (stable)
 * A (25)
 * C (25)
 * B (30)
 *
 * <p>
 * // Sorted (not stable) --> HeapSort can do this so it is unstable
 * C (25)
 * A (25)
 * B (30)
 * <p>
 * Now C comes before A, which breaks the original order.
 *
 * <p>
 * Use a stable sort when:
 * You're sorting based on one field but want to preserve original order based on another.
 * <p>
 * E.g., sorting by marks, but keeping original roll number order intact.
 *
 */
public class HeapSort {

    void heapSort(int arr[]) {
        int n = arr.length;
        //Step 1. Heapify
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        //Step2. Swap(first and last element and again heapify)
        delete(arr, arr.length);
    }

    private void heapify(int arr[], int index, int n) {
        int largest = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < n && arr[leftChildIndex] > arr[largest]) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < n && arr[rightChildIndex] > arr[largest]) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            swap(arr, largest, index);
            heapify(arr, largest, n);
        }

    }

    private void delete(int arr[], int n) {
        while (n != 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, 0, n);
        }
    }


    private void swap(int[] arr, int largest, int index) {
        int temp = arr[largest];
        arr[largest] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 9, 7};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
