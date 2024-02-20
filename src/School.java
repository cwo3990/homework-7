package src;

import java.util.Map;

import src.Visitor_Subsystem.BreakdownVisitor;

public class School extends Organization<Course> {
    public School(String name, Course[] courses) {
        super(name, courses);
    }

    public School(String name) {
        super(name);
    }

    public void setCourses(Course[] courses) {
        setChildren(courses);
    }

    @Override
    public Map<String, Integer> acceptBreakdownVisitor(BreakdownVisitor<String, Integer> visitor) {
        return visitor.visitSchool(this);
    }

    @Override
    public String toString() {
        return "The " + getName() + " school has " + getChildren().length + " courses.";
    }
    
}
