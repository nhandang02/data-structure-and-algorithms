import java.util.Stack;
public class ComputeP {
    public static int NonRecursive(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        if(n==1) return 3;
        else {
            int temp = 0;
            for(int i=2; i<=n; i++) {
                temp += 2*i + i*i + stack.peek();
                stack.push(temp);
            }
        }
        return stack.peek();
    }

    public static int RecursiveP(int n) {
        if(n==1) return 3;
        return 2*n + n*n + RecursiveP(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(RecursiveP(1));
        System.out.println(NonRecursive(1));
        System.out.println();
        System.out.println(RecursiveP(2));
        System.out.println(NonRecursive(2));
    }
}