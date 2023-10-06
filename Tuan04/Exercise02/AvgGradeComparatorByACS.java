import java.util.Comparator;

public class AvgGradeComparatorByASC implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getAVG() < s2.getAVG()) {
            return -1;
        }
        else if (s1.getAVG() > s2.getAVG()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}