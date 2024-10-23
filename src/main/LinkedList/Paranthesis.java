package main.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class Paranthesis {

    public static boolean isBalancedParentheses(String str) {
        List<Character> pa = new ArrayList<>();
        str.chars().mapToObj(e -> (char) e).forEach(e -> {

        if(pa.isEmpty()) pa.add(e);
        else{
            if (!(( pa.get(pa.size() - 1) + "" + e + "").equalsIgnoreCase("()"))) {
                pa.add(e);
            }
            else {
                pa.remove(pa.size()-1);
            }
        }
        });
        if (pa.size() % 2 != 0) return false;
        if (!pa.isEmpty() && (pa.get(0) + "").equalsIgnoreCase(")")) return false;
        for (int i = 0; i < pa.size() / 2; i++) {
            if (!(pa.get(i) + "".concat(pa.get(pa.size() - i - 1) + "")).equalsIgnoreCase("()")) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBalancedParentheses("()(())"));
    }


}
