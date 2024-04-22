package Algorithms;

/*
 * Heap is two types (complete binary tree):
 * max heap: parent larger that children
 * min heap: parent less that children
 *
 * large elements are at the left not right same as BST
 *
 * */

// 1  12  33
// i   l   r
public class HeapSort {
    // This for max heap, just make sure that the i (node) apply max heap property's
    private static void heapify(int[] arr, int size, int i) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int max = i;

        if (l < size && arr[l] > arr[max]) { // < to min heap
            max = l;
        }
        if (r < size && arr[r] > arr[max]) { // < to min heap
            max = r;
        }

        if (i != max) {
            swap(arr, i, max);
            heapify(arr, size, max);
        }
    }

    // This function make sure to iterate over all the array (left and right sub-tree)
    // by traverse over all parents and use heapify function
    private static void buildHeap(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }
    }

    private static void heapSort(int[] arr, int size) {
        buildHeap(arr, size);

        for (int i = size - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4};
        heapSort(arr, 5);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
