package ash_a9236.example;

import java.util.ArrayList;

public interface FileHandler {

    public void saveToFile(String fileName, ArrayList<Student> students, boolean append);

    public void loadFromFile(String fileName);

}
