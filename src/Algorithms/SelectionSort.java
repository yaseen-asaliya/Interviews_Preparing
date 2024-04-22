package Algorithms;

public class SelectionSort {
    public static void ArrSelectionSort(int[] arr){
        for (int i=0;i<arr.length -1 ;i++){
            for(int j=i;j < arr.length ;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,5,1};
        print(arr);
        ArrSelectionSort(arr);
        print(arr);
    }

    public static void print(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
