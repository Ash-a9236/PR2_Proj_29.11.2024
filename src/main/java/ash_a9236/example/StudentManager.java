package ash_a9236.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager implements FileHandler{
    private ArrayList<Student> students;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

/*______________________________________________________________________________________________________________________

 INHERITED METHOD.S
______________________________________________________________________________________________________________________*/

    public void saveToFileMain(String fileName) {
        saveToFile(fileName, students);
    }

    @Override
    public void saveToFile(String fileName, ArrayList<Student> students) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".csv"));

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

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName + ".csv"));
            String line = "";
            String[] strs = line.split(" ");

            for (String str : strs) {
                System.out.println(str);
            }

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("file not found");
            e.printStackTrace();
        }
    }

/*______________________________________________________________________________________________________________________

 CLASS METHOD.S
______________________________________________________________________________________________________________________*/

    public void addStudent (Student student) throws StudentNotFoundException {
        //ADDING STUDENTS
        students.add(student);
    }

    public void removeStudent (int id) throws StudentNotFoundException {
        students.remove(searchStudentByID(id));
    }

    public void displayStudents () {
        for (Student student : students) {
            System.out.println(student.getDescription());
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
    public ArrayList<Student> sortStudentByID () {
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
    public ArrayList<Student> sortStudentByGPA () {
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
