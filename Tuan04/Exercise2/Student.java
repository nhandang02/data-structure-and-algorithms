public class Student {
    String Sname;
    double mathematics = 0;
    double programming = 0;
    double  DSA1 = 0;

    public Student() {
        this.Sname = null;
    }

    public Student(String Sname, double mathematics, double programming, double  DSA1) {
        this.Sname = Sname;
        this.mathematics = mathematics;
        this.programming = programming;
        this.DSA1 = DSA1;
    }

    public String getSname() {
        return this.Sname;
    }
    public double getMath() {
        return this.mathematics;
    }
    public double getProg() {
        return this.programming;
    }
    public double getDSA1() {
        return this.DSA1;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }
    public void setMath(double point) {
        this.mathematics = point;
    }
    public void setProg(double point) {
        this.programming = point;
    }
    public void setDSA1(double point) {
        this.DSA1 = point;
    }

    public double getAVG() {
        double avg = (1/3.0 * (mathematics + programming + DSA1));
        return avg;
    }

    public String toString() {
        // return "Student[" + "Name: "+ Sname + ", Math: " + mathematics + ", Prog: " + programming + ", DSA1: " + DSA1 + ", AVG: " + this.getAVG() + "]";
        return "Student[" + "Name: "+ Sname +", AVG: " + this.getAVG() + "]";
    }
}
