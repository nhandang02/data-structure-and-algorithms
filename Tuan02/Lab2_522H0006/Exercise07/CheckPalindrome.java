import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckPalindrome {

    public static boolean isPalindrome(String input) {
        String input1 = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : input1.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false; 
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input1 = "15,//2,+-15";
        String input2 = "dang; thanh, nhan! /// nahnhnahtgnad";
        String input3 = "hello";

        System.out.println(isPalindrome(input1)); 
        System.out.println(isPalindrome(input2)); 
        System.out.println(isPalindrome(input3)); 
    }
}
