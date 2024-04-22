package Algorithms;
// https://www.youtube.com/watch?v=h8eyY7dIiN4&t=705s&ab_channel=CodingwithJohn
/*

 1  8   3   9   4   5   7

 lf                 rp  pivot

 lf++  until lf > pivot
 rp--  until rp < pivot
 then swap(lf,lr)

if(lv<=rp)
    swap(lf, pivot)

*/

import java.util.Random;

public class Quicksort {


    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int start, int end) {

        if (start >= end) {
            return;
        }

        int pivot = array[end];
        int leftPointer = partition(array, start, end, pivot);

        quicksort(array, start, leftPointer - 1);
        quicksort(array, leftPointer + 1, end);

    }

    private static int partition(int[] array, int start, int end, int pivot) {
        int leftPointer = start;
        int rightPointer = end - 1;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        if(array[leftPointer] > array[end]) {
            swap(array, leftPointer, end);
        }
        else {
            leftPointer = end;
        }

        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        quicksort(numbers);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}