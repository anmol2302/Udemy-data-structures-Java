package main.LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DLL {

    private Node head;
    private Node tail;
    private int length;

     class Node {

        Node next;
        Node prev;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public DLL(int data) {
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null || length==0) {
            head = newNode;
            tail = newNode;
            length = 1;
        } else {
            System.out.println("inside else block");

            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;

        }

    }

    public void prepend(int data) {

        if (head == null) {
            DLL dl = new DLL(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            length++;
        }


    }

    public void printDoubleLinkedList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            tail = tail.prev;
            tail.next = null;
            length--;

        }
    }

    public Node get(int index) {

        Node currentNode = head;
        int count = 0;
        while (currentNode != null) {
            if (count == index) return currentNode;
            currentNode = currentNode.next;
            count++;
        }
        return null;
    }

    public void insert(int index, int data) {

        if (head == null) {
            DLL newDL = new DLL(data);
        }
        if (index == 0) prepend(data);

        else {
            Node newNode = new Node(data);
            Node existingNode = get(index - 1);
            Node nextExistingNode = existingNode.next;
            nextExistingNode.prev = newNode;
            existingNode.next = newNode;
            newNode.prev = existingNode;
            newNode.next = nextExistingNode;
            length++;

        }
    }

    public void remove(int index) {

        if (head != null) {
            if (index == 0) removeFirst();
            else if (index == length) removeLast();
            else {
                Node node = get(index);
                Node existingNode = node.prev;
                Node next = node.next;
                existingNode.next = next;
                next.prev = existingNode;
                length--;
            }

        }


    }

    public void set(int index, int data) {

        if (head == null) {
            DLL dl = new DLL(data);
        } else {
            Node currentNode = head;
            int count = 0;

            while (currentNode != null) {
                if (index == count) {
                    length++;
                    currentNode.data = data;
                }
                count++;
                currentNode = currentNode.next;

            }


        }

    }

    public void removeFirst() {
        if (head != null) {
            length--;
            head = head.next;
            head.prev = null;
        }
    }

    public void reverse() {
        Node currentNode = head;
        Node prev = null;
        while (currentNode != null) {
            Node existingNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode.prev;
            currentNode = existingNode;
        }
        head = prev;
    }
    public void makeEmpty(){

        head = null;
        tail = null;
        length = 0;
    }



    public void anagramsOperation(String str){

         String str1  =  "xy";
         String str2 = "yx";
       //  System.out.println("str1:"+str1+":str2:"+str2);

         Map<Character, Long> charMapStr1 = str1.chars().mapToObj(e -> (char)e)
                 .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));

        Map<Character, Long> charMapStr2 = str2.chars().mapToObj(e -> (char)e)
                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));


       Map<Character, Long> remainingOperation = new HashMap<>();
        charMapStr1.entrySet().forEach(kv -> {
            if(charMapStr2.containsKey(kv.getKey())){
                if(charMapStr2.get(kv.getKey()) < kv.getValue()) {
                    long diff = Math.abs(charMapStr2.get(kv.getKey()) - kv.getValue());
                    remainingOperation.put(kv.getKey(), diff);
                }
            }
            else {
                remainingOperation.put(kv.getKey(), kv.getValue());
            }


        });

        Map<Character, Long> remainingOperation1 = new HashMap<>();
        charMapStr2.entrySet().forEach(kv -> {
            if(charMapStr1.containsKey(kv.getKey())){
                if(charMapStr1.get(kv.getKey()) < kv.getValue()) {
                    long diff = Math.abs(charMapStr1.get(kv.getKey()) - kv.getValue());
                    remainingOperation1.put(kv.getKey(), diff);
                }
            }
            else {
                remainingOperation1.put(kv.getKey(), kv.getValue());
            }
        });


        System.out.println(remainingOperation);
        System.out.println(remainingOperation1);


        long totalOperations = 0;

        totalOperations+= remainingOperation1.values().stream().mapToLong(e -> e).sum();
    //    totalOperations+= remainingOperation.values().stream().mapToLong(e -> e).sum();

        System.out.println(totalOperations);


//        System.out.println(charMapStr1);
//        System.out.println(charMapStr2);








    }


    public static void main(String[] args) {
        DLL doublyLinkedList = new DLL(1);
        doublyLinkedList.makeEmpty();
        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
//        doublyLinkedList.append(40);
//        doublyLinkedList.append(5);
//        doublyLinkedList.prepend(-1);
//        doublyLinkedList.prepend(-2);
//        doublyLinkedList.removeLast();
//        doublyLinkedList.removeFirst();
//        doublyLinkedList.printDoubleLinkedList();
//        Node node = doublyLinkedList.get(4);
//        System.out.println("Node data:" + node.data);
//        doublyLinkedList.set(1, -10);
//        doublyLinkedList.printDoubleLinkedList();
//        System.out.println("next one");
//        doublyLinkedList.insert(2, 100);
//
//        doublyLinkedList.insert(0, 11000);
//
//        doublyLinkedList.printDoubleLinkedList();
//        doublyLinkedList.remove(2);
//        System.out.println("after remove");
//        doublyLinkedList.reverse();
        doublyLinkedList.printDoubleLinkedList();
        doublyLinkedList.anagramsOperation("cdebbc");

    }

}
