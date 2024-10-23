package main.LinkedList;


public class Stacks {
    Node top;
    int height;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Stacks(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public int getTopValue() {
        return top.value;
    }

    public int getHeight() {
        return height;
    }

    public Node pop() {
        if (height == 0) return null;
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (top == null) {
            top = newNode;
            height = 1;
        } else {
            newNode.next = top;
            top = newNode;
            height++;
        }
    }

    public void printStack() {
        Node currentnode = top;
        while (currentnode != null) {
            System.out.println(currentnode.value);
            currentnode = currentnode.next;
        }
    }

    public static void main(String[] args) {

        Stacks stack = new Stacks(4);
        stack.push(5);
        stack.push(10);
        stack.printStack();
        System.out.println(stack.pop().value);
        System.out.println(stack.pop().value);
        System.out.println(stack.pop().value);

    }
}
