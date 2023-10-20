import java.util.Stack;

public class Question3 {
    public static int calculate(String[] expression) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String tmp: expression) {
            if(isNumber(tmp)) {
                stack.push(Integer.parseInt(tmp));
            } 
            if(tmp.equals("+") || tmp.equals("-")) {
                int o1 = stack.pop();
                int o2 = stack.pop();
                int o3;
                switch(tmp) {
                    case "+": 
                        o3 = o2 + o1;
                        break;
                    case "-":
                        o3 = o2 - o1;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid expression");
                }
                stack.push(o3);
            }
        }
        return stack.pop();
    }

    private static boolean isNumber(String str) {
        return str.matches("0|([1-9][0-9]*)");
    }

    public static void main(String args[]){
		System.out.println(calculate(new String[]{"3", "4", "+", "2", "1", "+", "-"}));
        System.out.println(calculate(new String[]{"34", "12", "+"}));
	}
}