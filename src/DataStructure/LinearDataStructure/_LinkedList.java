package DataStructure.LinearDataStructure;

import java.sql.SQLOutput;
import java.util.LinkedList;

class Node {
    int data;
    Node next;

    Node(int d) { data = d; }
}

class LinkedListImp {
    Node head;

    void add(LinkedListImp list,int data){
        Node newNode = new Node(data);
        if(list.head == null){
            head = newNode;
            return;
        }
        Node last = list.head;
        while(last.next!=null){
            last = last.next;
        }
        last.next = newNode;

    }


    void print(LinkedListImp list){
        Node temp = list.head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    String delete(LinkedListImp list, int data) {
        if(list.head == null){
            System.out.println("empty");
            return "List is empty";
        };
        if(list.head.next == null){
            if(list.head.data == data){
                head = null;
            }
        }
        if(list.head.data == data){
            list.head = head.next;
        }

        Node current = head;
        Node previous = null;
        while(current!=null){
            if(current.data == data){
                previous.next = current.next;
                return "Done";
            }
            previous = current;
            current = current.next;
        }
        System.out.println("Not found");
        return "";
    }

    void reverseLinkedList(LinkedListImp list) {
        if(list.head == null){
            return;
        }
        Node prev = null, current = list.head, next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        list.head = prev;
    }

    void printReverse(Node head){
        if(head == null)return;
        printReverse(head.next);
        System.out.print(head.data + " ");
    }
}

public class _LinkedList {
    public static void main(String[] args) {
        LinkedListImp list = new LinkedListImp();
        list.add(list,1);
        list.add(list,2);
        list.add(list,3);
        list.add(list,4);
        list.add(list,5);

        list.reverseLinkedList(list);
        list.print(list);

        System.out.println("========================");
        list.printReverse(list.head);

        list.delete(list,4);
        list.print(list);
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.remove();
        //System.out.println(ll.get(0));



    }
}
