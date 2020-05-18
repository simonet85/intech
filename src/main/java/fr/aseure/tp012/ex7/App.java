package fr.aseure.tp012.ex7;

public class App {
    public static void main(String[] args) {
        Student s1 = new Student().setGrade(13);
        Student s2 = new Student().setName("Anthony").setGrade(12);

        System.out.println(s1);
        System.out.println(s2);

        Person<Student> p1 = new Person<Student>(); // OK because Student extends Person
//        Person<Integer> p2 = new Person<Integer>(); // KO because Integer does not extends Person

    }
}

class Person<T extends Person<T>> {
    String name;

    public T setName(String name) {
        this.name = name;
        return (T) this;
    }
}

class Student extends Person<Student> {
    private int grade;

    public Student setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s got %d", this.name, this.grade);
    }
}