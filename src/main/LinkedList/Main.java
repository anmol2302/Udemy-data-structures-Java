package main.LinkedList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    public static String isValidString(String str) {

        Map<Long, Long> distinct = str.chars().mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting())).entrySet().
                stream().map(e -> e.getValue()).collect(Collectors.toList()).stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        if (distinct.size() > 2) return "NO";
        else if (distinct.size() == 1) return "YES";
        else {
            List<Long> charsoccurence = distinct.values().stream().toList();
            long maxOccurenceKey = charsoccurence.get(0) > charsoccurence.get(1) ? distinct.keySet().stream().toList().get(0) : distinct.keySet().stream().toList().get(1);
            distinct.remove(maxOccurenceKey);
            long otherKeyValue = distinct.values().stream().findFirst().get();
            long otherKey = distinct.keySet().stream().findFirst().get();
            long otherKeyDiffs = Math.abs(otherKey - otherKeyValue);

            if (otherKeyDiffs == 0 || otherKeyDiffs == maxOccurenceKey) return "YES";
            else return "NO";

        }
    }

    public static void anagram(String str) {
        String str1 = str.substring(0, str.length() / 2);
        String str2 = str.substring(str.length() / 2, str.length());

        Map<Character, Long> str1Map = str1.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map<Character, Long> str2Map = str2.chars().mapToObj(e -> (char) e).collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Map<Character, Long> differenceMap = new HashMap<>();
        Map<Character, Long> differenceMap2 = new HashMap<>();

        for (Map.Entry<Character, Long> mp : str1Map.entrySet()) {
            differenceMap.put(mp.getKey(), Math.abs(str2Map.getOrDefault(mp.getKey(), 0L) - mp.getValue()));

        }

        for (Map.Entry<Character, Long> mp : str2Map.entrySet()) {
            if (!differenceMap.containsKey(mp.getKey()))
                differenceMap2.put(mp.getKey(), Math.abs(str1Map.getOrDefault(mp.getKey(), 0L) - mp.getValue()));
        }

        int sum1 = (int) differenceMap.values().stream().mapToLong(e -> e).sum();
        int sum2 = (int) differenceMap2.values().stream().mapToLong(e -> e).sum();

        System.out.println(((sum1 + sum2) / 2));

    }


    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                if (i != j) {
                    if (m == arr.get(i) + arr.get(j)) {
                        indices.add(i + 1);
                        indices.add(j + 1);
                    }

                }
            }
        }

        return indices;
    }


    public static String getReverseString(String str) {

        int start = 0;
        int end = str.length() - 1;
        char[] strarray = str.toCharArray();

        while (start < end) {
            char temp = strarray[start];
            strarray[start] = strarray[end];
            strarray[end] = temp;
            start++;
            end--;
        }
        return new String(strarray);
    }

    public static int createPalindrome(String str1) {
        String reverseString = getReverseString(str1);
        if (str1.equalsIgnoreCase(reverseString)) return -1;
        System.out.println("initiating");
        int start = 0;
        int end = str1.length() - 1;

        while (start < end) {
            List<Character> arrTemp = str1.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            arrTemp.remove(start);
            String newString = arrTemp.stream().map(e -> e + "").collect(Collectors.joining());
            if (newString.equalsIgnoreCase(getReverseString(newString))) return start;
            arrTemp.add(start, str1.charAt(start));
            arrTemp.remove(end);
            String newStringFromEndMissing = arrTemp.stream().map(e -> e + "").collect(Collectors.joining());
            if (newStringFromEndMissing.equalsIgnoreCase(getReverseString(newStringFromEndMissing))) return end;
            start++;
            end--;
        }

        return -1;
    }


    public static int gcd(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;

        }
        return a;
    }


    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);

    }


    public static void getTotalX(List<Integer> a, List<Integer> b) {

        int lcm = a.get(0);

        for (int i = 1; i < a.size(); i++) {
            lcm = lcm(lcm, a.get(i));
        }

        int gcd = b.get(0);

        for (int j = 1; j < b.size(); j++) {
            gcd = gcd(gcd, b.get(j));
        }

        int count = 0;

        for (int i = lcm; i <= gcd; i++) {


            boolean isFactor = true;
            boolean isdIVISIBLE = true;
            for (int j = 0; j < a.size(); j++) {
                if (i % a.get(j) != 0) {
                    isFactor = false;
                }

            }
            for (int k = 0; k < b.size(); k++) {

                if (b.get(k) % i != 0) isdIVISIBLE = false;

            }

            if (isFactor && isdIVISIBLE) {

                System.out.println("the number is " + i);
                count++;
            }

        }

        System.out.println("the lcm is:" + lcm + ": and gcd is:" + gcd);
        System.out.println(count);

    }


    public static int truckTour(List<List<Integer>> petrolpumps) {
        int currentPetrol = 0;
        int startingPoint = 0;
        int totalDistance = 0;
        int totalPetrol = 0;

        for (int i = 0; i < petrolpumps.size(); i++) {

            int petrol = petrolpumps.get(i).get(0);
            int distance = petrolpumps.get(i).get(1);

            totalPetrol += petrol;
            totalDistance += distance;
            currentPetrol += petrol - distance;

            if (currentPetrol < 0) {
                startingPoint = i + 1;
                currentPetrol = 0;
            }
        }

        return totalPetrol < totalDistance ? -1 : startingPoint;
    }

    public static int cookies(int k, List<Integer> A) {
        Collections.sort(A);
        int operaion = 0;
        if(A.get(0)>k) return -1;


        for (int i = 0; i < A.size() - 2; i++) {
            if (A.get(i) >= k && A.get(i + 1) >= k) continue;
            else if (A.get(i) < k && A.get(i + 1) >= k) {
                int mixedCookieValue = A.get(i) + (2 * A.get(i + 1));
                A.add(mixedCookieValue);
                Collections.sort(A);
                operaion++;
            } else {
                int mixedCookieValue = A.get(i) + (2 * A.get(i + 1));
                A.add(mixedCookieValue);
                A.remove(i);
                A.remove(i+1);
                Collections.sort(A);
                operaion++;
            }


        }


        return operaion;
    }


    public static void main(String[] args) {
//        List<Integer> a = List.of(2, 4);
//        List<Integer> b = List.of(16, 32, 96);
//        Set<Integer>sets = new HashSet<>(a);
//        //  getTotalX(a, b);
//        // System.out.println(getReverseString("anmol"));
//        //  createPalindrome("aab");
//        // System.out.println(icecreamParlor(4, new ArrayList<>(List.of(2, 2, 4, 5))));
//        anagram("fdhlvosfpafhalll");
//        System.out.println(createPalindrome("aaab"));
//        List<List<Integer>> petrolpumps = List.of(
//                List.of(4, 6),
//                List.of(6, 5),
//                List.of(7, 3),
//                List.of(4, 5)
//        );
//        // System.out.println("the starting index is+"+truckTour(petrolpumps));
//        List<Integer> listss = new ArrayList<>();
//        listss.add(1);
//        listss.add(2);
//        listss.add(3);
//        listss.add(9);
//        listss.add(10);
//        listss.add(12);
//        listss.sort(Comparator.reverseOrder());
//        System.out.println(listss);;
//        System.out.println(cookies(7, listss));
//        List<Integer>initList = IntStream.range(0,10).boxed().map(i -> 0).collect(Collectors.toList());
//        initList.subList(0,3).clear();
//        System.out.println(initList);
//        initList.addAll(0, List.of(10,10,10));

        int[] arr = {1,2,3,4,5,};

        for(int i = 0 ; i<=arr.length/2 ; i++){
            System.out.println(arr[i]);
        }
        System.out.println("----------");
        for(int i = (arr.length/2)+1 ; i< arr.length ; i++){
            System.out.println(arr[i]);
        }



    }
}
