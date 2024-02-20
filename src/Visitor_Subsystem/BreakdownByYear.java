package src.Visitor_Subsystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import src.Club;
import src.Course;
import src.Organization;
import src.School;
import src.Student;

public class BreakdownByYear implements BreakdownVisitor<String, Integer>{

    private HashSet<Integer> visited_students = new HashSet<>();

    public void clear_visited() {
        visited_students.clear();
    }

    @Override
    public Map<String, Integer> visitOrganization(Organization organization) {
        Map<String, Integer> breakdown = new HashMap<>();
        for (Object child : organization.getChildren()) {
            Map<String, Integer> childBreakdown = ((Organization) child).acceptBreakdownVisitor(this);
            for (String year : childBreakdown.keySet()) {
                breakdown.put(year, breakdown.getOrDefault(year, 0) + childBreakdown.get(year));
            }
        }
        return breakdown;
    }

    @Override
    public Map<String, Integer> visitClub(Club club) {
        Map<String, Integer> breakdown = new HashMap<>();
        for (Student student : club.getChildren()) {
            if (this.visited_students.contains(student.getId())) {
                continue;
            }
            visited_students.add(student.getId());
            breakdown.put(student.getYear(), breakdown.getOrDefault(student.getYear(), 0) + 1);
        }
        return breakdown;
    }

    @Override
    public Map<String, Integer> visitSchool(School school) {
        Map<String, Integer> breakdown = new HashMap<>();
        for (Course course : school.getChildren()) {
            Map<String, Integer> childBreakdown = course.acceptBreakdownVisitor(this);
            for (String year : childBreakdown.keySet()) {
                breakdown.put(year, breakdown.getOrDefault(year, 0) + childBreakdown.get(year));
            }
        }
        return breakdown;
    }

    @Override
    public Map<String, Integer> visitCourse(Course course) {
        Map<String, Integer> breakdown = new HashMap<>();
        for (Student student : course.getStudents()) {
            if (this.visited_students.contains(student.getId())) {
                continue;
            }
            this.visited_students.add(student.getId());
            breakdown.put(student.getYear(), breakdown.getOrDefault(student.getYear(), 0) + 1);
        }
        return breakdown;
    }

    @Override
    public Map<String, Integer> visitStudent(Student student) {
        Map<String, Integer> breakdown = new HashMap<>();
        breakdown.put(student.getYear(), 1);
        return breakdown;
    }
    
}
