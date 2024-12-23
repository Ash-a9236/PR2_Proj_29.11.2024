package ash_a9236.example;

public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String getDescription();


/*______________________________________________________________________________________________________________________

 GETTERS & SETTERS
______________________________________________________________________________________________________________________*/

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
