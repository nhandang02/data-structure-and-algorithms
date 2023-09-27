public class Test {
    public static void main(String[] args) {
        RecursiveP a = new RecursiveP();
        NonRecursiveP b = new NonRecursiveP();
        System.out.println("Recursive: " + a.computeP(1));
        System.out.println("Non-Recursive: " + b.computeP(1));
    }
}