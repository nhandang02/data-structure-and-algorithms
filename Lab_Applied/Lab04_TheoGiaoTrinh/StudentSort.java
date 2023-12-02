import java.util.*;
class Student {
    private String Sname;
    private double mathGrade;
    private double programmingGrade;
    private double dsa1Grade;

    public Student(String Sname, double mathGrade, double programmingGrade, double dsa1Grade) {
        this.Sname = Sname;
        this.mathGrade = mathGrade;
        this.programmingGrade = programmingGrade;
        this.dsa1Grade = dsa1Grade;
    }

    public String getSname() {
        return this.Sname;
    }

    public double getAvgGrade() {
        return (mathGrade + programmingGrade + dsa1Grade) / 3.0;
    }
}

class AvgGradeCoparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getAvgGrade() < s2.getAvgGrade()) {
            return -1;
        }
        else if (s1.getAvgGrade() > s2.getAvgGrade()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

public class StudentSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dang Thanh Nhan", 7, 8, 9));
        students.add(new Student("Vo Nhat Hao", 8, 9, 10));
        students.add(new Student("Pham Van Phuc", 9, 9, 10));
        students.add(new Student("Nguyen Thanh Nhan", 8, 8, 9));
        students.add(new Student("Huynh Trong Tri", 6, 8, 7));  

        Comparator<Student> byAvgGradeAsc = new AvgGradeCoparator();
        students.sort(byAvgGradeAsc);

        for (Student stu : students) {
            System.out.println(stu.getSname() + ": " + stu.getAvgGrade());
        }
    }
}
