package main.LinkedList.hashtable;

import java.util.ArrayList;
import java.util.List;

public class MyHashTable {
    int size = 16;
    Node[] dataMap;


    class Node {
        String key;
        int value;
        Node next;


        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashTable(String key, int value) {
        Node newNode = new Node(key, value);
        dataMap = new Node[size];
        dataMap[0] = newNode;
    }

    public MyHashTable() {
        dataMap = new Node[size];
    }

    public void printHashTable() {
        Node[] tempArray = dataMap;
        int count = 0;
        for (Node node : tempArray) {
            System.out.println("Index is:" + count);
            while (node != null) {
                System.out.println(node.key + "=" + node.value);
                node = node.next;
            }
            count++;
        }
    }

    private int hashMethod(String key) {

        if (key == null) return 0;

        char[] array = key.toCharArray();

        int hash = 0;
        for (int i = 0; i < array.length; i++) {
            char ascii = array[i];
            hash = (hash + ascii * 23) % dataMap.length;
        }
        return hash;
    }

    public int get(String key) {
        int index = hashMethod(key);
        if (dataMap[index] == null) return -1;
        Node node = dataMap[index];
        Node temp = node;
        while (temp != null) {
            if (temp.key.equalsIgnoreCase(key)) return temp.value;
            temp = temp.next;
        }
        return Integer.parseInt(null);
    }

    public void set(String key, int value) {
        int index = hashMethod(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public List<String> keys() {
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                keys.add(temp.key);
                temp = temp.next;
            }

        }

        return keys;
    }

    public static void main(String[] args) {

        MyHashTable myHashTable = new MyHashTable();
        myHashTable.set("nails", 10);
        myHashTable.set("hello", 20);
        myHashTable.set("bolts", 100);
        System.out.println(myHashTable.get("hello"));
        System.out.println(myHashTable.get("bolts"));
        System.out.println(myHashTable.keys());

    }
}
