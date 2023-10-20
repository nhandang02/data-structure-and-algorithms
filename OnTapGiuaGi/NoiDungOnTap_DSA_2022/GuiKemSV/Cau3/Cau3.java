import java.util.Stack;

public class Cau3 {
    public static int calculate(String[] expression) {
        Stack<Integer> stack = new Stack<>();
         
        for (String str : expression) {
            if (isOperator(str)) {
                int o2 = stack.pop();
                int o1 = stack.pop();
                int result = Calculate(o1, o2, str);
                stack.push(result);
            }
            else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
    private static boolean isOperator(String c) {
        return c.equals("+") || c.equals("-");
    }
    private static int Calculate(int o1, int o2, String operator) {
        switch (operator) {
            case "+":
                return o1 + o2;
            case "-":
                return o1 - o2;     
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);

        }
    }

    public static void main(String args[]){
		System.out.println(calculate(new String[]{"31", "12", "+"}));
	}
}