package main.LinkedList.hashtable;

import java.util.Stack;

public class MyHashMap {

    Node[] dataMap;
    int SIZE = 100;

    class Node implements Comparable<Node> {

        Node left;
        Node right;
        String key;
        int value;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node other) {

            long asciiSelf = calculateTotalValue(this.key);
            long asciiOther = calculateTotalValue(other.key);

            if (asciiSelf == asciiOther) return 0;
            else if (asciiSelf > asciiOther) return -1;
            else {
                return 1;
            }

        }

        public long calculateTotalValue(String str) {
            long ascii = 0;
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                ascii += array[i];
            }
            return ascii;
        }
    }

    public MyHashMap() {
        dataMap = new Node[SIZE];
    }

    public int hash(String key) {

        char[] array = key.toCharArray();
        int hash = 0;
        for (int i = 0; i < array.length; i++) {
            char ascii = array[i];
            hash = (hash + ascii * 23) / dataMap.length;

        }
        return hash;
    }

    public void put(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (true) {
                if (temp.compareTo(newNode) == 1) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    }
                    temp = temp.right;
                } else if (temp.compareTo(newNode) == -1) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    }
                    temp = temp.left;
                } else {
                    temp.value = value;
                    break;
                }
            }

        }
    }

    public void printTree() {
        System.out.println("Initiating printing...");
        if (dataMap == null) {
            System.out.println("Tree is empty.");
            return;
        }
        for (int i = 0; i < dataMap.length; i++) {
            Node root = dataMap[i];
            Stack<Node> stack = new Stack<>();
            Node current = root;
            StringBuilder prefix = new StringBuilder();
            boolean isLeft = true;

            while (current != null || !stack.isEmpty()) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                current = stack.pop();

                // Print the current node with its prefix
                System.out.println(prefix.toString() + (isLeft ? "├── " : "└── ") + current.key + ":" + current.value);

                // Prepare prefix for the right child
                prefix.append(isLeft ? "│   " : "    ");

                // Move to the right child
                current = current.right;
                isLeft = false; // For the first right child, it's no longer left
            }
        }
    }

    public Node get(String key) {
        int index = hash(key);
        if (dataMap[index] == null) return null;
        Node temp = dataMap[index];
        long hashSearchKey = calculateTotalValue(key);
        while (temp != null) {
            long hash = calculateTotalValue(key);
            if (temp.key.equalsIgnoreCase(key)) return temp;
            else if (hash > hashSearchKey) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("key1", 10);
        map.put("key2", 20);
        map.put("key3", 30);
        map.put("key4", 40);
        map.put("key5", 50);
        map.put("key6", -189);
        System.out.println(map.get("key2").value);

    }

    public static long calculateTotalValue(String str) {
        long ascii = 0;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            ascii += array[i];
        }

        return ascii;


    }

}
