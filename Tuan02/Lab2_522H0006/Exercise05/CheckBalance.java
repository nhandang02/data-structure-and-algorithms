import java.util.Stack;
public class CheckBalance {
    public static boolean CheckBalance(String input) {
        Stack<Character> stack = new Stack<>();

        for(char c : input.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')    stack.push(c); 
            else if (c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false;

                char leftChar = stack.pop();
                if(!(leftChar == '(' && c == ')' 
                || leftChar == '{' && c == '}'
                || leftChar == '[' && c == ']')) return false;
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        System.out.println(CheckBalance("{{()}}"));
        System.out.println(CheckBalance("{}()[]"));
        System.out.println(CheckBalance("(}[){]"));
    }
}