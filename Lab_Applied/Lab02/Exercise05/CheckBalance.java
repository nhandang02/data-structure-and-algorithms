 public class CheckBalance {
    public static boolean CheckBalance(String input) {
        MyStack<Character> stack = new MyStack<>();

        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; 
                }

                char leftChar = stack.pop();
                if ((c == ')' && leftChar != '(') ||
                    (c == '}' && leftChar != '{') ||
                    (c == ']' && leftChar != '[')) {
                    return false; 
                }
            }
        }

        return stack.isEmpty(); 
    }
}