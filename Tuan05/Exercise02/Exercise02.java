import java.util.*;
public class Exercise02 {

    public static boolean checkPalinDrome(int n) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        if (n < 10) return false;
        while (n != 0) {
            stack.push(n % 10);
            queue.add(n % 10);
            n /= 10;
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove()))    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPalinDrome(152251));
    }

}