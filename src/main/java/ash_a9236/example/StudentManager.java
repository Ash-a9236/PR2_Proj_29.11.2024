package ash_a9236.example;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;

    public void addStudent (Student student) {
        students.add(student);
    }

    public void removeStudent (int id) {

    }



    public Student searchStudentByID (int id) {
        return searchStudentRecursiveHelper(id, 0);
    }

    private Student searchStudentRecursiveHelper (int id, int index) {
        //base case
        if (index >= students.size()) {
            return null;
        }

        //body
        if (students.get(index).getId() == id) {
            return students.get(index);
        }

        //recursion
        return searchStudentRecursiveHelper (id, index + 1);
    }

    public ArrayList<Student> sortStudentByID (ArrayList<Student> students) {
        ArrayList<Student> sortedStudents = null;

        return sortedStudents;
    }

}
