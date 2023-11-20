import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class Question3 {
    public static boolean isPalindrome(String str) {
        Stack<String> stack = new Stack<String>();
        Queue<String> queue = new LinkedList<String>();

        for(int i = 0; i < str.length(); i++) {
            String ch = str.substring(i , i + 1);
            stack.push(ch);
            queue.offer(ch);
        }

        if(stack.pop().equals(queue.poll())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("TDTU"));
        System.out.println(isPalindrome("ABCBA"));
        
    }
}