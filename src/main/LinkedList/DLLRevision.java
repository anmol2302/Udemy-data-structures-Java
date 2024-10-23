package main.LinkedList;

public class DLLRevision {
    int length;
    Node head;
    Node tail;

    class Node {


        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DLLRevision(int value) {
        Node newNode = new Node(value);
        length = 1;
        head = newNode;
        tail = newNode;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        newNode.prev = null;
        head.prev = newNode;
        head = newNode;
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }

    }

    public void reverse(){
        Node currentNode = head;
        Node prev = null;
        while (currentNode!=null){
            Node next = currentNode.next;
            currentNode.next = currentNode.prev;
            currentNode.prev = next;
            prev = currentNode;
            currentNode = next;
        }
      head = prev;
    }

    public static void main(String[] args) {

        DLLRevision dll = new DLLRevision(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.prepend(-1);
        dll.prepend(-2);
        dll.print();
        System.out.println("after reversing");
        dll.reverse();
        dll.print();


    }

}
