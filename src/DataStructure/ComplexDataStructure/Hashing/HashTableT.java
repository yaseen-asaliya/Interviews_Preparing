package DataStructure.ComplexDataStructure.Hashing;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/*
Hashing has 3 types
1- Replace values
    index = value & array_size
    ex: 40 % 10 = 4
    ex: (99-97) % 10 = 2

2- Open Addressing
  2.1 linear probing
    * in case of conflict search for the next empty index
    ex: index = 40 % 10 = 4 but 4 is full (conflict)
    sol: search for next empty index +1...

  2.2 Quadratic probing
    i = 0; // number of conflict (increase from first conflict)
    last_index = (index + i^2) % array_size
    ex: last_index = ((40 % 10) + 1^2) % 10)
                   = (4 - 1) % 10
                   = 4

3- Chaining
    |0| -> { 1,2 }
    |1| -> { }
    |2| -> { }
    |3| -> { }
    |4| -> { 3,13 }
*/
class Hashing {
    // Replace values
    static void replaceVal(int[] arr, int data){
        int index = data % arr.length;
        arr[index] = data;
    }

    //  linear probing
    static void linearProbing(int[] arr, int data){
        int index = data % arr.length;
        if(arr[index] != 0){
            for(int i=index;i<arr.length;i++){
                if(arr[i]==0){
                    arr[i] = data;
                    return;
                }
            }
        }
        else{
            arr[index] = data;
            return;
        }
        System.out.println("Array is full.");
    }

    static void quadraticProbing(int[] arr, int data) {
        int index = data % arr.length, pointer = 0;

        if (arr[index] == 0) {
            arr[index] = data;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            pointer++;
            int last_index = (int) ((index + Math.pow(pointer, 2)) % arr.length);

            if (arr[last_index] == 0) {
                arr[last_index] = data;
                return;
            }
        }

        System.out.println("Array is full");
    }

    public static void chaining(Hashtable<Integer, List<Integer>> table, int data) {
        int size = 10;
        int index = data % size;

        if(!table.containsKey(index)){
            List<Integer> temp = new ArrayList<>();
            temp.add(data);
            table.put(index, temp);
        }
        else{
            List<Integer> list = table.get(index);
            list.add(data);
            table.put(index, list);
        }
    }

    public static void print(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printChaining(Hashtable<Integer, List<Integer>> table){
        table.forEach((key, item) ->{
            System.out.println(key + ":");
            for(int i=0;i<item.size();i++){
                System.out.print(" " + item.get(i));
            }
            System.out.println();
        });
    }
}


public class HashTableT {
    public static void main(String[] args) {

        // same as HashMap but this is use with multi threading environments
        Hashtable<Integer,Integer> table;

        System.out.println((char) 65); // A
        System.out.println((int) 'a'); // 97

        int[] arr = { 1,2,3,0,0,0,0,0,0,0 };
        Hashing.print(arr);

        Hashing.replaceVal(arr,504);
        Hashing.print(arr);

        Hashing.linearProbing(arr,12);
        Hashing.print(arr);

        Hashing.quadraticProbing(arr,17);
        Hashing.print(arr);

        Hashtable<Integer, List<Integer>> ta = new Hashtable<>(10);
        Hashing.chaining(ta,1);
        Hashing.chaining(ta,10);
        Hashing.chaining(ta,20);
        Hashing.chaining(ta,15);
        Hashing.printChaining(ta);

        Scanner scanner = new Scanner(System.in);
        String xx = scanner.nextLine();
        int x2 = scanner.nextInt();
        System.out.println(xx);
        System.out.println(x2);

        Hashing[] arr2 = new Hashing[10];

    }
}
