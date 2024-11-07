package ash_a9236.example;

import java.util.Scanner;

public class Student extends Person {
    private int semester;
    private int id;
    private double GPA;

    /*
    DELIVERABLE 2 INFORMATIONS
    - Enhance the Student Management System to support additional functionalities.
    - Implement methods to add, delete, search, and display students.
    - Add support for saving students to a text file and loading students from a text file.
    - Test the file operations thoroughly.
 */

    //
//    public void addStudent() {
//        Scanner console = new Scanner(System.in);
//        System.out.println("Please input the student roll number");
//        int rollNumber = console.nextInt();
//        String extraLine = console.nextLine();
//
//        if (findStudent(rollNumber) == null) {
//            System.out.println("Input the student's full name : ");
//            String name = console.nextLine();
//            students.add(new Student(name, rollNumber));
//            System.out.println("Student added successfully.");
//        } else {
//            System.out.println("Student No " + rollNumber + " already exists in the system");
//        }
//    }

    @Override
    void getDescription() {

    }



    public void addStudent () {

    }


/*______________________________________________________________________________________________________________________

 GETTERS & SETTERS
______________________________________________________________________________________________________________________*/

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}
