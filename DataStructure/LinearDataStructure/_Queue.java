package DataStructure.LinearDataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class _Queue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.element());
        queue.clear();

    }
}
