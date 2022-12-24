package access_modifier.student;

import access_modifier.student.Student;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Thuấn");
        student.setClasses("A09");
        System.out.println("Name: "+ student.getName()+" .Class: "+student.getClasses());
    }
}
