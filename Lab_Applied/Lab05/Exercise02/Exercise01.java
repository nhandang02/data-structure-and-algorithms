import java.util.Stack;

public class Exercise01 {
    public static double calculatePostfix(String s) {
        String[] split = s.split(" ");
        Stack<String> stack = new Stack<>();

        for (String ch : split) {
            if (isOperator(ch)) {
                double b = Double.parseDouble(stack.pop());
                double a = Double.parseDouble(stack.pop());
                double res = performOperation(a, b, ch);
                stack.push(String.valueOf(res));
            } else {
                stack.push(ch);
            }
        }

        return Double.parseDouble(stack.pop());
    }

    private static boolean isOperator(String ch) {
        return ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/");
    }

    private static double performOperation(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String postfixExpression = "9 2 - 6 * 7 + 7 /";
        double result = calculatePostfix(postfixExpression);
        System.out.println("Result: " + result);
    }
}
