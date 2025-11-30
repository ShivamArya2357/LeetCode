package Practice.src.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentComparator {

    public static void main(String[] args) {

        Comparator<Student2> nameComparator = (o1, o2) -> o2.getStudentName().compareTo(o1.getStudentName());
        Comparator<Student2> markComparator = (o1, o2) -> o2.getMarks() - o1.getMarks();
        Comparator<Student2> rollNoComparator = (o1, o2) -> -o1.getRollNo() + o2.getRollNo();

        Student2 s1 = new Student2(123, "Shivam", 90);
        Student2 s2 = new Student2(234, "Shaurya", 100);
        Student2 s3 = new Student2(128, "Manisha", 95);
        List<Student2> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        Collections.sort(students, nameComparator);
        System.out.println("Students sorted on names");
        for (Student2 student : students) {
            System.out.print(student.getStudentName() + " ");
        }
        System.out.println();

        Collections.sort(students, markComparator);
        System.out.println("Students sorted on marks");
        for (Student2 student : students) {
            System.out.print(student.getStudentName() + " ");
        }
        System.out.println();

        Collections.sort(students, rollNoComparator);
        System.out.println("Students sorted on rollNos");
        for (Student2 student : students) {
            System.out.print(student.getStudentName() + " ");
        }
        System.out.println();
    }
}
