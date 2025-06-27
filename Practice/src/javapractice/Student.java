package Practice.src.javapractice;

public class Student implements Comparable<Student> {

    private int rollNo;

    private String studentName;

    private int marks;

    public Student(int rollNo, String studentName, int marks) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return other.rollNo - this.rollNo;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getMarks() {
        return marks;
    }
}
