public class Test {
    public static void main(String[] args) {
        CharLinkedList c = new CharLinkedList();
        c.addFirst('c');
        c.addFirst('b');
        c.addFirst('A');
        System.out.println(c.addAfterFirstKey('E', 'b'));
        c.print();
        System.out.println(c.largestCharPosition());


    }
}
