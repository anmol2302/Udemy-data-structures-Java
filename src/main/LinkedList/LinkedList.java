package main.LinkedList;


import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedList {

    Node head;
    Node tail;

    class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void removeLast() {
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    public Node get(int index) {
        Node currentNode = head;
        int i = 0;
        if (currentNode == null) {
            return null;
        }
        while (currentNode.next != null) {
            if (i == index) return currentNode;
            i++;
            currentNode = currentNode.next;
        }
        return null;
    }

    /**
     * 10 -> 12 -> 0 -> 1 -> 2 -> 3
     *
     * @param index
     * @param value
     * @return
     */
    public boolean set(int index, int value) {
        Node currentNode = head;
        Node newNode = new Node(value);

        if (index == 0)
            prepend(value);

        for (int i = 0; currentNode != null; i++) {
            if (i == index - 1) {
                Node tempNode = currentNode.next;
                currentNode.next = newNode;
                newNode.next = tempNode;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }


    public boolean remove(int index) {
        Node currentNode = head;

        if(index == 0) {
            head = head.next;
        }

        for (int i = 0; currentNode != null; i++) {
            if (i == index - 1) {
                currentNode.next = currentNode.next.next;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;

    }

    public void removeFirst() {
        head = head.next;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void main(String[] args) {

        List<Integer> li1 = List.of(2,2,1,3,2);

        int d = 4;
        int m = 2;

        List<Integer> li2 = List.of(4,5,6);
        List<Integer> li3= List.of(10,8,-12);

        List<List<Integer>> array = List.of(li1,li2,li3);

       String str = "We promptly judged antique ivory buckles for the next prize";
        System.out.println(str.chars().mapToObj(ele -> (char)ele).filter(ele -> Character.isAlphabetic(ele)).collect(Collectors.toSet()).size()==26);


//        System.out.println(li.stream().collect(Collectors.groupingBy(ele -> ele , Collectors.counting())).entrySet().stream().filter(
//                ele -> ele.getValue()==1).map(ele -> ele.getKey()).collect(Collectors.toList()).get(0));





//        LinkedList li = new LinkedList();
//
//        for (int i = 0; i < 3; i++) {
//            li.add(i);
//        }
//          printLinkedList(li.head);
////        li.prepend(10);
////        System.out.println("New linked list");
////        printLinkedList(li.head);
////        // li.removeLast();
////        //li.removeFirst();
////        //li.removeFirst();
////        System.out.println("New linked list");
////        //printLinkedList(li.head);
////        li.prepend(12);
////        printLinkedList(li.head);
////        li.set(3, 100);
////        System.out.println(li.get(3).value);
////        printLinkedList(li.head);
////        System.out.println(li.getLength());
////        li.set(0, 1000);
////        printLinkedList(li.head);
////        li.remove(0);
//        li.reverse();
//        System.out.println("Linked list after reverse");
//        printLinkedList(li.head);
    }


    public  void reverseLinkedList() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev;               // Reverse the pointer
            prev = current;                    // Move prev and current one step forward
            current = next;
        }
        head = prev;
    }
    public void reverse(){
        // 0 -> 1 -> 2    ||    0  <- 1 <- 2

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

    }


    public int getLength() {
        Node currentNode = head;
        int size = 0;
        while (currentNode.next != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

    }


    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println("LinkedList elements are:" + current.value);
            current = current.next;
        }

        List<Integer> li = List.of(1,-1,2,0,3);
        li.stream().collect(Collectors.groupingBy(ele -> {
            if(ele == 0) return "zero";
            else if(ele%2==0) return "+ve";
            else return "-ve";
        }, Collectors.counting())).entrySet().stream().forEach(kv -> System.out.println(kv.getValue()/li.size()));
    }
}
