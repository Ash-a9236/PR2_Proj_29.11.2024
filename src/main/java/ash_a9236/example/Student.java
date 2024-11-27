package ash_a9236.example;

import javax.xml.namespace.QName;
import java.util.Objects;

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

/*______________________________________________________________________________________________________________________

 INHERITED METHOD.S
______________________________________________________________________________________________________________________*/

    @Override
    String getDescription() {
        return "STUDENT " + getId()
                + "\n   Name : " + getName()
                + "\n   Semester : " + getSemester()
                + "\n   GPA :      " + getGPA();
    }

    public Student(String name, int age, int semester, int id, double GPA) {
        super(name, age);
        this.semester = semester;
        this.id = id;
        this.GPA = GPA;
    }

/*______________________________________________________________________________________________________________________

 CLASS METHOD.S
______________________________________________________________________________________________________________________*/

    public String convertToCSVFormat () {
        return getName() + "," + getAge() + "," + id + "," + semester + "," + GPA;
    }

/*______________________________________________________________________________________________________________________

 EQUALS & HASHCODE
______________________________________________________________________________________________________________________*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return semester == student.semester && id == student.id && Double.compare(GPA, student.GPA) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(semester, id, GPA);
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
