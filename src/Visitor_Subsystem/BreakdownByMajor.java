package src.Visitor_Subsystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import src.Club;
import src.Course;
import src.Organization;
import src.School;
import src.Student;

public class BreakdownByMajor implements BreakdownVisitor<String, Integer> {
    private HashSet<Integer> visited_students = new HashSet<>();

    public void clear_visited() {
        visited_students.clear();
    }

    @Override
    public Map<String, Integer> visitOrganization(Organization organization) {
        Map<String, Integer> breakdown = new HashMap<>();
        for (Object child : organization.getChildren()) {
            Map<String, Integer> childBreakdown = ((Organization) child).acceptBreakdownVisitor(this);
            for (String major : childBreakdown.keySet()) {
                breakdown.put(major, breakdown.getOrDefault(major, 0) + childBreakdown.get(major));
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
            this.visited_students.add(student.getId());
            breakdown.put(student.getMajor(), breakdown.getOrDefault(student.getMajor(), 0) + 1);
        }
        return breakdown;
    }

    @Override
    public Map<String, Integer> visitSchool(School school) {
        Map<String, Integer> breakdown = new HashMap<>();
        for (Course course : school.getChildren()) {
            Map<String, Integer> childBreakdown = course.acceptBreakdownVisitor(this);
            for (String major : childBreakdown.keySet()) {
                breakdown.put(major, breakdown.getOrDefault(major, 0) + childBreakdown.get(major));
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
            breakdown.put(student.getMajor(), breakdown.getOrDefault(student.getMajor(), 0) + 1);
        }
        return breakdown;
    }

    @Override
    public Map<String, Integer> visitStudent(Student student) {
        Map<String, Integer> breakdown = new HashMap<>();
        breakdown.put(student.getMajor(), 1);
        return breakdown;
    }
    
}
