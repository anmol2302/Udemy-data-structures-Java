package main.LinkedList;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Queue {

    Node first;
    Node last;
    int length;

    class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;

    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
            last = newNode;
            length = 1;

        } else {
            last.next = newNode;
            last = newNode;
            length++;
        }
    }

    public Node dequeue() {
        Node temp = first;
        if (length == 0) return null;
        else if (length == 1) return first;
        else {
            first = first.next;
            temp.next = null;
        }
        length--;

        return temp;


    }

    public static void main(String[] args) {
       Stack<String> st = new Stack();
       String str = "aa";
        Queue queue = new Queue(10);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        System.out.println("dequeqing:" + queue.dequeue().value);
        System.out.println("dequeqing:" + queue.dequeue().value);
        System.out.println("dequeqing:" + queue.dequeue().value);

        List<Integer>lis = new ArrayList<>();
        lis.add(1);
        lis.add(2);
        lis.add(3);
        lis.add(4);
        lis.add(5);
        lis.add(6);
        System.out.println(lis.remove(0));  // Arraylist works like both queue or stacks.
        System.out.println(lis);

    }

}
