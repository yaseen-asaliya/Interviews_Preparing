package Algorithms;

public class InsertionSort {

    private static void arrInsertSort(int[] arr) {
        int size = arr.length, j;
        for(int i=1;i< size;i++){
            int key = arr[i];
            j = i-1;
            while(j>=0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,4,2,5,1};
        print(arr);
        arrInsertSort(arr);
        print(arr);
    }

    public static void print(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
