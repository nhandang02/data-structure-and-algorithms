public class Exercise08_Test {
    public static void main(String[] args)  {
        Exercise08_LinkedList<Integer> list = new Exercise08_LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(6);
        list.print();

        list.addSortedList(2);
        list.print();
        list.addSortedList(4);
        list.addSortedList(5);
        list.print();

        System.out.println(list.countEvenNum());
        System.out.println(list.sumAllNum());

    }
}
