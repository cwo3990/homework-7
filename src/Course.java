package src;

import java.util.Map;

import src.Visitor_Subsystem.BreakdownVisitor;

public class Course {
    private String name;
    private String code;
    private Student[] students;

    public Course(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Map<String, Integer> acceptBreakdownVisitor(BreakdownVisitor<String, Integer> visitor) {
        return visitor.visitCourse(this);
    }

    @Override
    public String toString() {
        return "The " + name + " course has " + students.length + " students.";
    }
}
