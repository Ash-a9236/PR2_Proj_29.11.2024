package ash_a9236.example;

/*______________________________________________________________________________________________________________________

    Final Project
    Written by Helene Rousseau, 6229734
    For Programming 2 Section 00002 - Fall 2024

_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
    Explanation :
    .
    .
    .
    .
______________________________________________________________________________________________________________________*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws StudentNotFoundException {
        ArrayList<Student> students = new ArrayList<>();
        StudentManager sm = new StudentManager(students);

        Scanner console = new Scanner(System.in);
        String userAns;


        Student student01 = new Student("Anna Liverpool",  18, 2, 1001, 3.5);
        Student student02 = new Student("John Doe",        19, 3, 1002, 3.7);
        Student student03 = new Student("Maria Garcia",    20, 4, 1003, 3.9);
        Student student04 = new Student("David Miller",    21, 2, 1004, 3.6);
        Student student05 = new Student("Emily Turner",    22, 3, 1005, 3.8);
        Student student06 = new Student("Michael Brown",   23, 4, 1006, 3.4);
        Student student07 = new Student("Sophia Davis",    24, 1, 1007, 3.3);
        Student student08 = new Student("James Wilson",    25, 2, 1008, 3.2);
        Student student09 = new Student("Olivia Martinez", 20, 3, 1009, 3.9);
        Student student10 = new Student("Liam Anderson",   21, 4, 1010, 3.5);

        sm.addStudent(student01);
        sm.addStudent(student02);
        sm.addStudent(student03);
        sm.addStudent(student04);
        sm.addStudent(student05);
        sm.addStudent(student06);
        sm.addStudent(student07);
        sm.addStudent(student08);
        sm.addStudent(student09);
        sm.addStudent(student10);

        System.out.println("_________________________________________________________________");
        System.out.println("         Welcome to the Library Management System!\n");
        System.out.println("    1. Add Student                      5. Save to File");
        System.out.println("    2. Find Student                     6. Load from File");
        System.out.println("    3. Display Students                 7. Sort Students By ID");
        System.out.println("    4. Delete Student                   8. Sort Students By GPA");
        System.out.println("                       9. Exit");
        System.out.println("_________________________________________________________________\n");

        userAns = console.next();
        switch (userAns) {
            case "1":
                System.out.println("ADDING STUDENT");

                System.out.println("ADDING STUDENT");
                System.out.print("Enter Student ID : ");
                int ID = console.nextInt();
                String IDExtraLine = console.nextLine();

                if (sm.checkIfStudentExists(ID) == null) {
                    //NAME
                    System.out.println("Enter Student Name : ");
                    String name = console.nextLine();

                    //AGE
                    System.out.println("Enter Student Age");
                    int age = console.nextInt();

                    //SEMESTER
                    System.out.println("Enter Student Semester : ");
                    int semester = console.nextInt();
                    String SemesterExtraLine = console.nextLine();

                    //GPA
                    System.out.println("Enter Student GPA : ");
                    double GPA = console.nextDouble();
                    String GPAExtraLine = console.nextLine();

                    //ADDING STUDENT
                    Student tempStudent = new Student(name, age, semester, ID, GPA);
                    sm.addStudent(tempStudent);

                } else {
                    System.out.println("Wrong ID, Please Try Again");
                }
                break;

            case "2":
                System.out.println("FINDING STUDENT");
                System.out.print("Enter Student ID : ");
                int ID01 = console.nextInt();
                String IDExtraLine01 = console.nextLine();

                sm.searchStudentByID(ID01);
                break;

            case "3":
                System.out.println("DISPLAYING STUDENTS");

                sm.displayStudents();
                break;

            case "4":
                System.out.println("DELETING STUDENT");
                System.out.print("Enter Student ID : ");
                int ID02 = console.nextInt();
                String IDExtraLine02 = console.nextLine();

                sm.removeStudent(ID02);
                //sm.displayStudents();
                break;

            case "5":
                System.out.println("SAVING TO FILE");
                System.out.print("Enter File Name : ");

                String junkline03 = console.nextLine();
                String fileName = console.nextLine();
                //fileName.substring(0, fileName.indexOf("."));

                sm.saveToFileMain(fileName);
                break;

            case "6":
                System.out.println("LOAD FROM FILE");
                System.out.print("Enter File Name : ");
                String junkline04 = console.nextLine();
                String fileName01 = console.nextLine();
                //fileName01.substring(0, fileName01.indexOf("."));

                sm.loadFromFile(fileName01);

                break;

            case "7":
                System.out.println("SORT STUDENTS BY ID");

                sm.sortStudentByID();
                System.out.println("\n\n");
                sm.displayStudents();
                break;

            case "8":
                System.out.println("SORT STUDENTS BY GPA");

                sm.sortStudentByGPA();
                System.out.println("\n\n");
                sm.displayStudents();
                break;

            case "9":
                System.out.println("Exiting program. Thank you!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }


    }

}