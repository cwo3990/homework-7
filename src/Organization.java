package src;

import java.util.Map;

import src.Visitor_Subsystem.BreakdownVisitor;

public abstract class Organization<T> {
    private String name;
    private T[] children;

    public Organization(String name, T[] children) {
        this.name = name;
        this.children = children;
    }

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public T[] getChildren() {
        return children;
    }

    public void setChildren(T[] children) {
        this.children = children;
    }

    public Map<String, Integer> acceptBreakdownVisitor(BreakdownVisitor<String, Integer> visitor) {
        return visitor.visitOrganization(this);
    }

    @Override
    public String toString() {
        return "The " + name + " organization has " + children.length + " children.";
    }
    
}
