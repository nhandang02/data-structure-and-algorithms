import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortStudent implements Comparator<Student> {
    public static void main(String[] args) {
        ArrayList<Student> ST = new ArrayList<>();
        ST.add(new Student("Dang Thanh Nhan", 7, 8, 9));
        ST.add(new Student("Vo Nhat Hao", 8, 9, 10));
        ST.add(new Student("Pham Van Phuc", 9, 9, 10));
        ST.add(new Student("Nguyen Thanh Nhan", 8, 8, 9));
        ST.add(new Student("Huynh Trong Tri", 6, 8, 7));        

        for (Student stu : ST) {
            System.out.println(stu.toString());
        }

        // Sort in ascending order
        Collections.sort(ST, new SortStudent());

        System.out.println("Ascending Order:");
        for (Student stu : ST) {
            System.out.println(stu.toString());
        }

        // Sort in descending order
        Collections.sort(ST, Collections.reverseOrder(new SortStudent()));

        System.out.println("\nDescending Order:");
        for (Student stu : ST) {
            System.out.println(stu.toString());
        }
    }

    
    public static double compare(Student s1, Student s2) {
        // Compare by average grade
        return Double.compare(s1.getAVG(), s2.getAVG());
    }
}
