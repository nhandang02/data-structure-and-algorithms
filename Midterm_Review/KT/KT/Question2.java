import java.util.Stack;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class Question2 {
    public static String reverseSentence(String s) {
        // YOUR CODE HERE
        Stack<Character> stack = new Stack<>();
        List<String> list = new LinkedList<>();
        // list.add(s); // add Last
        // String first = list.remove(0);// remove First
        // return first;
        //return null;
        char ch [] = s.toCharArray();
        for (char c : ch) {
            stack.push(c);
        }
        StringBuffer result = new StringBuffer();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // System.out.println(reverseSentence(12321));
        // System.out.println(reverseSentence("1232"));
        System.out.println(reverseSentence("love"));
    }
}