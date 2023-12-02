import java.util.*;
public class Exercise03 {
    public static String reverseString(String str) {
        Stack<String> stack = new Stack<>();
        String[] words = str.split(" ");
        StringBuffer result = new StringBuffer();
        for (String word : words) {
            stack.push(word + " ");
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("I like apple"));
    }
}
