package main.LinkedList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class Student {
    private String name;
    private int grade;

    // Constructor, getters, and setters
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

public class Exercise {


    public static int longestConsecutiveSequence(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        Set<Set<Integer>> numsSet = new HashSet<>();
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> counter = new HashSet<>();
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i != (nums.length - 1)) {
                if (nums[i] + 1 == nums[i + 1]) {
                    numSet.add(nums[i]);
                    numSet.add(nums[i] + 1);
                    count++;
                } else if (nums[i] == nums[i + 1]) continue;

                else {
                    counter.add(count);
                    count = 1;
                    numsSet.add(numSet);
                    numSet = new HashSet<>();
                }
            } else {
                counter.add(count);
                numsSet.add(numSet);
            }
        }

        return counter.stream().mapToInt(e -> e).max().getAsInt();

    }

    public static int[] subarraySum(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k < j + 1; k++) {
                    sum += nums[k];
                }
                if (sum == target) {
                    System.out.println(i + ":" + j);
                    return new int[]{i, j};
                }
            }


        }

        return new int[]{};
    }

    public void groupStudentsByGrade() {

        List<Student> students = Arrays.asList(
                new Student("Alice", 90),
                new Student("Bob", 80),
                new Student("Alice", 95),
                new Student("Charlie", 85)
        );
        LinkedHashMap<String, Integer> maps = students.stream().collect(Collectors.toMap(k -> k.getName(), v -> v.getGrade(), (e1, e2) -> Math.max(e1, e2), LinkedHashMap::new));
        System.out.println(maps);
    }

    public static void maxSumSubArray(List<Integer>arr){

        int totalSum = arr.stream().mapToInt(e->e).sum();
        int maxSum = totalSum;
        for(int i = 0 ;i< arr.size();i++){
            totalSum = totalSum - arr.get(i);
            if(totalSum>maxSum) maxSum = totalSum;
        }

        System.out.println(maxSum);


    }

    public static void  maxSubarray(List<Integer> arr) {
//-2,-1,-2,-3,-4,-5
        System.out.println(-2+(-3));
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : arr) {
                currentSum += num;
            System.out.println("the current sum is"+currentSum);

            // Update the maximum subarray sum if currentSum is greater
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // Reset currentSum if it drops below zero
            if (currentSum < 0) {
                currentSum = 0;
            }
        }


        List<Integer>pairs = new ArrayList<>();
        pairs.add(maxSum);
        System.out.println(pairs);
    }


    public static void main(String[] args) {
//        System.out.println(subarraySum(new int[]{5},5));
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);

     //   myList.stream().sorted((s1, s2) -> s2.compareTo(s1));
//
//        Set<Integer>sets = new HashSet<>(myList);
//        myList = sets.stream().collect(Collectors.toList());
//
//        String str = "leetcode";
//        String newStr = str.chars().mapToObj(e->(char)e).distinct().map(e->e+"").collect(Collectors.joining());
//        System.out.println(newStr+":old str:"+str);

 //       System.out.println(longestConsecutiveSequence(new int[]{1, 2, 2, 3, 4}));

        maxSubarray(List.of(-2,-1,-2,-3,-4,-5));

        String str = "i.like.this.program.very.much";



        String[] array = str.split("\\.");
        System.out.println(IntStream.range(0, array.length).boxed().map(i-> array[array.length-i]).collect(Collectors.joining(".")));
        String newStr = "";
        for(int i = array.length-1; i>=0; i-- ){
            newStr=newStr.concat(array[i]+".");
        }Set<Integer> sets = new HashSet<Integer>();
        System.out.println(newStr.trim());
        newStr.substring(0, newStr.length()-2);

    }
}
