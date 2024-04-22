package DataStructure.ComplexDataStructure.Hashing;

import java.util.HashMap;
import java.util.Map;

public class HashMapT {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,100);
        map.put(2,200);
        map.put(3,100);
        map.put(3,300);
        map.remove(1);

        map.containsKey(2);
        map.containsValue(100);
        map.get(1); //indexes starts from 1 and it will return the values
        map.getOrDefault(1,-1);
        map.isEmpty();

        map.keySet();   // iterate over keys
        map.values();   // iterate over values
        map.entrySet(); // iterate over each item <key, value>

        for(int i=0;i<map.size();i++){
            System.out.println(map.get(i));
        }

        System.out.println("======================");
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
            item.getKey();
            item.getValue();
        }

        // recommended
        map.forEach((key,value) -> {
            System.out.println(key + " " + value);
        });
    }
}
