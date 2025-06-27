package Practice.src.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentComparable {

    public static void main(String[] args) {

        Student s1 = new Student(123, "Shivam", 90);
        Student s2 = new Student(234, "Shaurya", 100);
        Student s3 = new Student(128, "Manisha", 95);
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.getRollNo() + " " + student.getStudentName() + " " + student.getMarks());
        }
    }
}
