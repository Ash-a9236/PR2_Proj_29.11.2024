package ash_a9236.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager implements FileHandler{
    private ArrayList<Student> students;

/*______________________________________________________________________________________________________________________

 INHERITED METHOD.S
______________________________________________________________________________________________________________________*/

    @Override
    public void saveToFile(String fileName, ArrayList<Student> students) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("StudentList.csv"));

            //Header
            writer.write("NAME, AGE, ID, SEMESTER, GPA");
            writer.newLine();

            for (Student student : students) {
                writer.write(student.convertToCSVFormat());
                writer.newLine();
            }

            System.out.println("Data Written To File");

        } catch (IOException e) {
            System.out.println("Cannot perform task");
            e.printStackTrace();
        }

    }

    @Override
    public void loadFromFile(String fileName) {

    }

/*______________________________________________________________________________________________________________________

 CLASS METHOD.S
______________________________________________________________________________________________________________________*/


    public void addStudent (Student student) throws StudentNotFoundException {
        Scanner console = new Scanner(System.in);

        System.out.println("ADDING STUDENT");
        System.out.print("Enter Student ID : ");
        int ID = console.nextInt();
        String IDExtraLine = console.nextLine();

        if (searchStudentByID(ID) != null) {
            System.out.println("Enter Student Name : ");
            String name = console.nextLine();

            System.out.println("Enter Student Age");
            int age = console.nextInt();

            System.out.println("Enter Student Semester : ");
            int semester = console.nextInt();
            String SemesterExtraLine = console.nextLine();

            System.out.println("Enter Student GPA : ");
            double GPA = console.nextDouble();
            String GPAExtraLine = console.nextLine();

            students.add(new Student(name, age, semester, ID, GPA));
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


    // sorting by ID with insertion sort
    public ArrayList<Student> sortStudentByID (ArrayList<Student> students) {
        int size = students.size();

        for (int i = 0; i > size; i++) { //loop through the ArrayList<>
            Student key = students.get(size);
            int j = i - 1;

            while (j >= 0 && students.get(j).getId() > key.getId()) {
                students.set(j + 1, students.get(j)); // Shifts students to the right
                j--; // move to the left
                students.set(j + 1, key); //insert the current student in the correct position
            }
        }
        return students;
    }


    // sorting by GPA with insertion sort
    public ArrayList<Student> sortStudentByGPA (ArrayList<Student> students) {
        int size = students.size();

        for (int i = 0; i > size; i++) { //loop through the ArrayList<>
            Student key = students.get(size);
            int j = i - 1;

            while (j >= 0 && students.get(j).getGPA() > key.getGPA()) {
                students.set(j + 1, students.get(j)); // Shifts students to the right
                j--; // move to the left
                students.set(j + 1, key); //insert the current student in the correct position
            }
        }
        return students;
    }


}
