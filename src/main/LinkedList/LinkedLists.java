package main.LinkedList;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LinkedLists {

    Node head;
    Node tail;

    class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
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

    public void printLL() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null" + "\n");
    }

    public void printLL(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null" + "\n");
    }

    public void reverse() {

        Node current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void append(int value) {
        Node newnode = new Node(value);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }


    }


    public Node parseLinkedList(Node head1, Node head2) {

        Node head = null;
        Node temp1 = head1;
        Node temp2 = head2;
        Node tail = null;


        while (true) {
            if (temp1 != null && temp2 != null) {
                if (temp1.value > temp2.value) {
                    if (head == null) {
                        Node newNode = new Node(temp2.value);
                        head = newNode;
                        tail = newNode;
                    } else {
                        Node newNode = new Node(temp2.value);
                        tail.next = newNode;
                        tail = newNode;
                    }
                    temp2 = temp2.next;

                } else {
                    if (head == null) {
                        Node newNode = new Node(temp1.value);
                        head = newNode;
                        tail = newNode;
                    } else {
                        Node newNode = new Node(temp1.value);
                        tail.next = newNode;
                        tail = newNode;
                    }
                    temp1 = temp1.next;
                }

            } else {
                break;
            }
        }
        if (temp2 == null) {
            while (temp1 != null) {
                Node newNode = new Node(temp1.value);
                tail.next = newNode;
                tail = newNode;
                temp1 = temp1.next;

            }

        }
        if (temp1 == null) {
            while (temp2 != null) {
                Node newNode = new Node(temp2.value);
                tail.next = newNode;
                tail = newNode;
                temp2 = temp2.next;
            }
        }


        return head;
    }


    public static void makeStringValid(int d, String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            String sub = str.substring(i, i + d);
            if (!sub.contains("1")) count++;
        }
        System.out.println(count);
    }

    public static int pairs(int k, List<Integer> arr) {


        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                if (i != j) {
                    int diff = Math.abs(arr.get(i) - arr.get(j));
                    if (diff == k) pairs.add(List.of(arr.get(i), arr.get(j)));
                }
            }
        }
        System.out.println(pairs);
        return pairs.size();
    }


    public static void main(String[] args) {

        LinkedLists li = new LinkedLists();
        LinkedLists li2 = new LinkedLists();
        li.add(1);
        li.add(3);
        li.add(5);
        li2.add(0);
        li2.add(2);

        List<String> strslist = List.of("100", "2", "300", "-1");

//
//        String str = "hello";
//        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
//        firstNonRepeatingChar("leetcode");
//        System.out.println("the bvalue is" + str.substring(0, 0));
//        System.out.println(palindromeIndex("aaab"));
//        System.out.println(getModifiedString(2, "aaab"));
////        Node newHead = li.parseLinkedList(li.head, li2.head);
////        System.out.println("printing");
////        li.printLL(newHead);
//        //  pairs(2, List.of(1,5, 3, 4, 2));


        IntStream.range(0,2).flatMap(i-> IntStream.range(0,2).map(j-> j)).forEach(System.out::println);

    }


    public static boolean isPalindrome(String str) {
        int end = str.length() - 1;
        int start = 0;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static String getModifiedString(int index, String str) {
        return str.substring(0, index).concat(str.substring(index + 1, str.length()));
    }

    public static Character firstNonRepeatingChar(String str) {

        LinkedHashMap<Character, Long> maps = str.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()));
        for (Map.Entry<Character, Long> mp : maps.entrySet()) {
            if (mp.getValue() == 1) return mp.getKey();
        }
        return null;


    }


    public int[] twoSum(int k, int[]array){

        Map<Integer, Integer>maps = new HashMap<>();
        Set<Integer>indices = new HashSet<>();
        int index = 0;


        for(int ar:array){
            maps.put(ar, index);
            index++;
        }

        for(Map.Entry<Integer, Integer>mapp:maps.entrySet()){
            int diff = Math.abs(mapp.getKey()-k);
            if(maps.containsKey(diff)){
                if(!indices.contains(maps.get(diff))) {
                    indices.add(maps.get(diff));
                    if(!maps.containsKey(mapp.getValue()))
                         indices.add(mapp.getValue());
                }
            }

        }


        return indices.stream()
                .mapToInt(Integer::intValue) // Convert Integer to int
                .toArray();

    }


    public static List<List<String>>groupAnagrams(String[]strs){

        Map<List<String>, List<String>>maps = new HashMap<>();
        for(String str:strs){
            if(maps.isEmpty()) {
                List<String>charlist = new ArrayList<>();
                charlist.add(str);
                maps.put(Arrays.stream(str.split("")).sorted().toList(), charlist);}
            else{
                List<String>keys = Arrays.stream(str.split("")).sorted().toList();
                if(maps.containsKey(keys)){
                    List<String> values = maps.get(keys);
                    values.add(str);
                    maps.replace(keys, values);
                }
                else{
                    List<String> values = new ArrayList<>();
                    values.add(str);
                    maps.put(keys,values);
                }
            }

        }
        return maps.values().stream().collect(Collectors.toList());


    }


    public static int palindromeIndex(String s) {
        if (s.isBlank()) return -1;
        else if (isPalindrome(s)) return -1;
        else {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    if (isPalindrome(s.substring(start + 1, end + 1))) return start;
                    else if (isPalindrome(s.substring(start, end))) return end;
                    else return -1;
                }
                start++;
                end--;
            }
        }
        return -1;
    }

}
