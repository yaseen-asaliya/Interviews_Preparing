package ProblemSolving;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {

    public static HashMap<Integer, Integer> test(){
        int[] arr = {1,2,3,5};
        int amount = 11, cuumlative = 0;
        HashMap<Integer, Integer> res = new HashMap<>();

        for(int i=arr.length -1 ;i >= 0; i--){
            for(int j=0; j <= amount && arr[i] <= amount - cuumlative ; j+=arr[i]){
                cuumlative+=arr[i];

                if(!res.containsKey(arr[i])){
                    res.put(arr[i],1);
                }
                else {
                    res.put(arr[i],res.get(arr[i]) + 1);
                }
                if(cuumlative == amount)return res;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        HashMap<Integer, Integer> res = test();
        res.forEach((key,val)->{
            System.out.println(key + " : " + val);
        });

    }
}
