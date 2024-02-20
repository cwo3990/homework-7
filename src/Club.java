package src;

import java.util.Map;

import src.Visitor_Subsystem.BreakdownVisitor;

public class Club extends Organization<Student>{
    public Club(String name, Student[] children) {
        super(name, children);
    }

    public Club(String name) {
        super(name);
    }

    @Override
    public Map<String, Integer> acceptBreakdownVisitor(BreakdownVisitor<String, Integer> visitor) {
        return visitor.visitClub(this);
    }

    @Override
    public String toString() {
        return "The " + getName() + " club has " + getChildren().length + " members.";
    }
}
