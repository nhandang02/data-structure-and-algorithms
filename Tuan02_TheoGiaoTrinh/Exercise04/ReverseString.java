import java.util.Stack;
public class ReverseString {

    public static String Reverse(String input) {
        Stack<Character> stack = new Stack<>();

        char[] input1 = input.toCharArray();

        for(int i=0; i<input1.length; i++) {
            stack.push(input1[i]);
        }

        StringBuffer reversed = new StringBuffer();
        
        while(!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(Reverse("123456"));
        System.out.println(Reverse("152204"));
    }
}