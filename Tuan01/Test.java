public class Test {
    public static void main (String[] args) {
        FractionLinkedList list = new FractionLinkedList();
        
        list.add(new Fraction(1, 2));
        list.add(new Fraction(3, 4));
        list.add(new Fraction(2, 5));
        
        list.print();
        
        list.remove(new Fraction(3, 4));
        
        list.print();
    }
}