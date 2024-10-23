package main.LinkedList;

public class BST {
    private Node root;

    class Node {

        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public BST(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }

    public boolean insertNode(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
    }

    public boolean contains(int value) {
        Node temp = root;
        while (temp != null) {
            if (value == temp.value) return true;
            else if (value > temp.value) temp = temp.right;
            else temp = temp.left;
        }
        return false;
    }

    public static void main(String[] args) {

        BST myBST = new BST(10);
        myBST.insertNode(11);
        myBST.insertNode(12);
        myBST.insertNode(27);
        myBST.insertNode(45);
        System.out.println(myBST.contains(27));


    }

}
