package Algorithms;

public class BubbleSort {
    public static void ArrBubbleSort(int[] arr){
        for (int i=0;i<arr.length -1 ;i++){
            for (int j=0;j<arr.length - i - 1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,5,1};
        print(arr);
        ArrBubbleSort(arr);
        print(arr);
    }

    public static void print(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
