public class NonRecursiveP {
    public static int computeP(int n) {
        if (n == 1) {
            return 3;
        }

       MyStack<Integer> stack = new MyStack<>();
        stack.push(3);
        int result = 0;

        for (int i = 2; i <= n; i++) {
            int temp = 2 * i + i * i + stack.getPeek();
            stack.push(temp);
        }

        return stack.getPeek();
    }
}