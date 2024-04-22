package Algorithms;

import java.util.Random;

public class MergeSort {
    public static void merge(int[] arr,int min, int mid, int max) {
        int leftSize = mid-min + 1;
        int rightSize = max - mid;
        int[] leftSide = new int[leftSize];
        int[] rightSide = new int[rightSize];

        for(int i=min ;i<leftSize ;i++){
            leftSide[i] = arr[leftSize + i];
        }

        for(int i=min ;i<rightSize ;i++){
            rightSide[i] = arr[rightSize + i];
        }

        int i=0,j=0,key=min;
        while (i < leftSize && j < rightSize){
            if(leftSide[i] <= rightSide[j]){
                arr[key] = leftSide[i];
                i++;key++;
            }
            else{
                arr[key] = rightSide[j];
                j++;key++;
            }
        }

        while (i < leftSize) {
            arr[key++] = leftSide[i++];
        }
        while (i < rightSize) {
            arr[key++] = rightSide[i++];
        }

    }

    public static void mergeSort(int[] arr,int start, int end){
        if(start<=end)return;
        int mid = start + (end - start) / 2;
        mergeSort(arr,start, mid);
        mergeSort(arr,mid + 1, end);
        merge(arr,start,mid,end);
    }


    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        mergeSort(numbers,0,numbers.length-1);

        System.out.println("\nAfter:");
        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
