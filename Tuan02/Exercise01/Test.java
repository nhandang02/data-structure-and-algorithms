public class Test {
    public static void main (String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(new Fraction(1, 2));
        stack.push(new Fraction(3, 4));
        stack.push(new Fraction(5, 6));
        stack.print();
        System.out.println();

        System.out.println("#Contains: " + stack.contains(new Fraction(1, 2)));
        System.out.println();

        System.out.println("#GetPeek: " + stack.getPeek());
        stack.print();
        System.out.println();

        System.out.println("Pop1: " + stack.pop());
        stack.print();
        System.out.println();
        System.out.println("Pop2: " +stack.pop());
        stack.print();
        System.out.println();
        System.out.println("Pop3: " + stack.pop());
        stack.print();
        System.out.println();

        System.out.print("IsEmpty: " + stack.isEmpty());
        System.out.println();
    }
}