import java.util.*;

public class SortStudent {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Dang Thanh Nhan", 7, 8, 9));
        students.add(new Student("Vo Nhat Hao", 8, 9, 10));
        students.add(new Student("Pham Van Phuc", 9, 9, 10));
        students.add(new Student("Nguyen Thanh Nhan", 8, 8, 9));
        students.add(new Student("Huynh Trong Tri", 6, 8, 7));        


        Comparator<Student> byAvgGradeAsc = new AvgGradeComparatorByASC();
        students.sort(byAvgGradeAsc);

        for (Student stu : students) {
            System.out.println(stu.toString());
        }

        System.out.println();

        Comparator<Student> byAvgGradeDesc = new AvgGradeComparatorByDESC();
        students.sort(byAvgGradeDesc);

        for (Student stu : students) {
            System.out.println(stu.toString());
        }
    }
}
