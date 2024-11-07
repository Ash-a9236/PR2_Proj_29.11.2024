package ash_a9236.example;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;

    public void addStudent (Student student) throws StudentNotFoundException {
        Scanner console = new Scanner(System.in);

        System.out.println("ADDING STUDENT");
        System.out.print("Enter Student ID : ");
        int ID = console.nextInt();
        String IDExtraLine = console.nextLine();

        if (searchStudentByID(ID) != null) {
            System.out.println("Enter Student Semester : ");
            int semester = console.nextInt();
            String SemesterExtraLine = console.nextLine();

            System.out.println("Enter Student GPA : ");
            double GPA = console.nextDouble();
            String GPAExtraLine = console.nextLine();

            students.add(new Student(semester, ID, GPA));
        }
    }

    public void removeStudent (int id) throws StudentNotFoundException {
        students.remove(searchStudentByID(id));
    }

    public void displayStudents () {
        for (Student student : students) {
            System.out.println(student);
        }
    }



    public Student searchStudentByID (int id) throws StudentNotFoundException {
        return searchStudentRecursiveHelper(id, 0);
    }

    private Student searchStudentRecursiveHelper (int id, int index) throws StudentNotFoundException {
        //base case
        if (index >= students.size()) {
            throw new StudentNotFoundException("Student not found!");
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
