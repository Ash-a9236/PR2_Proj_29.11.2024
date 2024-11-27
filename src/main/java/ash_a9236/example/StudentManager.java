package ash_a9236.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
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
        saveToFile(fileName, students, true);
    }

    @Override
    public void saveToFile(String fileName, ArrayList<Student> students, boolean append) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter( fileName + ".csv", append));

            //Header
            writer.write("ID, NAME, AGE, SEMESTER, GPA");
            writer.newLine();

            for (Student student : students) {
                String toCVS = student.getId() + ", "
                        + student.getName() + ", "
                        + student.getAge() + ", "
                        + student.getSemester() + ", "
                        + student.getGPA();
                writer.write(toCVS);
                writer.newLine();
            }

            writer.close();

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
            String[] strs = line.split(",");

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
        if (students.get(index).getId() == id) {
            System.out.println(students.get(index).getDescription());
            return students.get(index);
        }

        if (index >= students.size()) {
            throw new StudentNotFoundException("Student not found in system");
        }

        if (students.get(index).getId() != id) {
            return searchStudentRecursiveHelper(id, index + 1);
        }

        return null;
    }

    public Student checkIfStudentExists (int id) {
        int idx = 0;
        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("Student " + id + " exists in the system");
                return student;
            }
        }
        return null;
    }


    public ArrayList<Student> sortStudentByID () {
        students.sort(Comparator.comparing(Student::getId));
        return students;
    }


    public ArrayList<Student> sortStudentByGPA () {
        students.sort(Comparator.comparing(Student::getGPA));
        return students;
    }


}
