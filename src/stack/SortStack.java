package stack;

import main.LinkedList.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortStack {


//    public static Stack sortStack(Stack stacks) {
//        Stack<Integer> sortedStack = new Stack<>();
//        Stack<Integer> stack = stacks;
//        while (stack.peek() != null) {
//            if (sortedStack.isEmpty()) sortedStack.push(stack.pop());
//            else {
//                int fetchedValue = stack.pop();
//                int count = 0;
//                while (sortedStack.peek() != null) {
//                    if (sortedStack.peek() < fetchedValue) {
//                        stack.push(sortedStack.pop());
//                        count++;
//                    }
//                    else{
//                        break;
//                    }
//                }
//                sortedStack.push(fetchedValue);
//                for (int j = 0; j < count; j++) {
//                    sortedStack.push(stack.pop());
//                }
//
//
//            }
//        }
//
//        stacks = sortedStack;
//        stacks.printStack();
//        return sortedStack;
//
//    }

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            Stack<Integer> sortedStack = new Stack<>();
            while (stack.peek() != null) {
                if (sortedStack.isEmpty()) sortedStack.push(stack.pop());
                else {
                    int fetchedValue = stack.pop();
                    int count = 0;
                    while (sortedStack.peek() != null) {
                        if (sortedStack.peek() < fetchedValue) {
                            stack.push(sortedStack.pop());
                            count++;
                        } else {
                            break;
                        }
                    }
                    sortedStack.push(fetchedValue);
                    for (int j = 0; j < count; j++) {
                        sortedStack.push(stack.pop());
                    }
                }
            }
            int size = sortedStack.getStackList().size();
            for (int i = 0; i < size; i++) {
                stack.push(sortedStack.getStackList().get(i));
            }
        }
    }


    public static boolean isEligible(List<Integer> initialSeq, int existing, int newComer) {

        return Math.abs(initialSeq.indexOf(existing) - initialSeq.indexOf(newComer)) <= 2 ? true : false;


    }

    public static String countOperation(List<Integer> sequence) {

        List<Integer> initialSeq = new ArrayList<>(sequence);
        Collections.sort(initialSeq);
        int operation = 0;
        for (int i = 0; i < initialSeq.size(); i++) {
            if (initialSeq.get(i) != sequence.get(i)) {
                if (isEligible(initialSeq, initialSeq.get(i), sequence.get(i))) {
                    operation += Math.abs(initialSeq.indexOf(initialSeq.get(i)) - initialSeq.indexOf(sequence.get(i)));
                } else {
                    return "Too chaotic";
                }
            }
        }
        return operation + "";
    }


    public static String isBalanced(String str) {
        List<Character> charStack = new ArrayList<>();
        str.chars().mapToObj(e -> (char) e).forEach(e -> {
            if(charStack.isEmpty()) charStack.add(e);
            else {
                if (!(((charStack.get(charStack.size() - 1) + "" + e + "").equalsIgnoreCase("()")) || (charStack.get(charStack.size() - 1) + "" + e + "").equalsIgnoreCase("[]") || (charStack.get(charStack.size() - 1) + "" + e + "").equalsIgnoreCase("{}")))
                    charStack.add(e);
                else charStack.remove(charStack.size()-1);
            }


        });

        if(charStack.isEmpty()) return "YES";
        for(int i =0 ;i < charStack.size()/2 ; i++){
            if (!(charStack.get(i) + "".concat(charStack.get(charStack.size() - i - 1) + "")).equalsIgnoreCase("()")) return "NO";
            else if (!(charStack.get(i) + "".concat(charStack.get(charStack.size() - i - 1) + "")).equalsIgnoreCase("[]")) return "NO";
            else if (!(charStack.get(i) + "".concat(charStack.get(charStack.size() - i - 1) + "")).equalsIgnoreCase("{}")) return "NO";
        }



        return "YES";
    }


    public static void main(String[] args) {

        Stack<Integer> orignalStack = new Stack();
        orignalStack.push(3);
        orignalStack.push(4);
        orignalStack.push(1);
        orignalStack.push(2);
        orignalStack.push(100);
        orignalStack.push(5);
        orignalStack.push(-1);
        //  System.out.println(orignalStack.getStackList().get(0));

//        List<Integer> li = List.of(1, 2, 5, 3, 7, 8, 6, 4);
//        String result = countOperation(new ArrayList<>(li));
//        System.out.println(result);
        System.out.println(isBalanced("{{[[(())]]}]"));
    }


}
