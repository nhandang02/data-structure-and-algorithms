public class Test {
    public static void main(String[] args) {
        CharLinkedList charList = new CharLinkedList();
        charList.addFirst('A');
        charList.addAfterFirstKey('b', 'A');
        charList.addAfterFirstKey('c', 'b');
        charList.getHead();

        charList.print();
        charList.addAfterFirstKey('B', 'b');
        charList.print();
        System.out.println(charList.largestCharPostition());
        charList.addFirst('v');
        charList.print();
        System.out.println(charList.largestCharPostition());
    }
}
