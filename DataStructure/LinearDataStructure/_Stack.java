package DataStructure.LinearDataStructure;
import java.io.*;
import java.util.*;


public class _Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        System.out.println(stack.peek());
        System.out.println(stack.search(2));
        int x = 2;
        stack.push(x);
        stack.pop();
        System.out.println(stack.peek());


    }
}
