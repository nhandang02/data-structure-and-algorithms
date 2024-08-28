public class Test {
    public static void main(String[] args) {
        IntLinkedList nums = new IntLinkedList();
        nums.addFirst(1);
        nums.addFirst(2);
        nums.addFirst(3);
        nums.addFirst(4);

        nums.addLast(1);
        nums.addLast(2);
        nums.addLast(5);
        nums.addLast(4);

        nums.print();
        System.out.println(nums.checkSorted());
        System.out.println(nums.countOdd());
        System.out.println(nums.searchKey(6));
        System.out.println(nums.removeAt(5));
        nums.print();
    }
}
