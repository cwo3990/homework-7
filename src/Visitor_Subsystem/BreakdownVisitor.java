package src.Visitor_Subsystem;
import java.util.Map;

import src.Club;
import src.Course;
import src.Organization;
import src.School;
import src.Student;

public interface BreakdownVisitor<K, V> {
    Map<K, V> visitOrganization(Organization organization);
    Map<K, V> visitClub(Club club);
    Map<K, V> visitSchool(School school);
    Map<K, V> visitCourse(Course course);
    Map<K, V> visitStudent(Student student);
}
