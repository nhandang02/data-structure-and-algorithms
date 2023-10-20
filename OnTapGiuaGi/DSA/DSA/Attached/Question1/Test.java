public class Test {
    public static void main(String[] args) {
        CharLinkedList list = new CharLinkedList();

        list.addFirst('c');
        list.addFirst('b');
        list.addFirst('A');
        list.print();

        boolean add = list.addAfterFirstKey('E', 'b');
        System.out.println(add);

        list.print();

        int maxPos = list.largestCharPostition();
        System.out.println(maxPos);
    }
}