package src;

import java.util.Map;

import src.Visitor_Subsystem.BreakdownVisitor;

public class Student {
    private static int idCounter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String major;
    private String year; // Freshman, Sophomore, Junior, Senior

    public Student(String firstName, String lastName, String major, String year) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMajor() {
        return major;
    }

    public String getYear() {
        return year;
    }

    public Map<String, Integer> acceptBreakdownVisitor(BreakdownVisitor<String, Integer> visitor) {
        return visitor.visitStudent(this);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " is a " + year + " " + major + " major.";
    }
}
