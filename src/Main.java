package src;

import java.util.Map;

import src.Visitor_Subsystem.BreakdownByMajor;
import src.Visitor_Subsystem.BreakdownByYear;

public class Main {
    public static void printMap(Map<String, Integer> map, String title) {
        System.out.println(title);
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Student[] students = new Student[9];
        students[0] = new Student("John", "Doe", "Software Engineering", "Senior");
        students[1] = new Student("Jane", "Doe", "Computer Science", "Junior");
        students[2] = new Student("Alice", "Doe", "Computer Engineering", "Sophomore");
        students[3] = new Student("Bob", "Doe", "Software Engineering", "Freshman");
        students[4] = new Student("Eve", "Doe", "Computer Science", "Senior");
        students[5] = new Student("Mallory", "Doe", "Computer Engineering", "Junior");
        students[6] = new Student("Oscar", "Doe", "Biology", "Sophomore");
        students[7] = new Student("Charlie", "Doe", "Art", "Freshman");
        students[8] = new Student("Trent", "Doe", "Business", "Senior");

        BreakdownByYear breakdownByYear = new BreakdownByYear();
        BreakdownByMajor breakdownByMajor = new BreakdownByMajor();
        // breakdown by year and major for an club example
        Club club = new Club("Generic Club", students);
        printMap(breakdownByYear.visitClub(club), club.getName() + " breakdown by year example");
        printMap(breakdownByMajor.visitClub(club), club.getName() + " breakdown by major example");
        breakdownByMajor.clear_visited();
        breakdownByYear.clear_visited();

        // breakdown by year and major for a course example
        Course course = new Course("Generic Course", students);
        printMap(breakdownByYear.visitCourse(course), course.getName() + " breakdown by year example");
        printMap(breakdownByMajor.visitCourse(course), course.getName() + " breakdown by major example");
        breakdownByMajor.clear_visited();
        breakdownByYear.clear_visited();

        // breakdown by year and major for a school example
        School school = new School("College of Computing and Information Sciences");
        Course course1 = new Course("SWEN 101", new Student[] {students[0], students[3]});
        Course course2 = new Course("SWEN 102", new Student[] {students[1], students[4]});
        Course course3 = new Course("SWEN 103", new Student[] {students[2], students[5]});
        Course course4 = new Course("SWEN 104", new Student[] {students[6], students[7]});
        Course course5 = new Course("SWEN 105", new Student[] {students[8]});
        Course course6 = new Course("SWEN 106", new Student[] {students[0], students[1], students[2]});
        school.setCourses(new Course[] {course1, course2, course3, course4, course5, course6});
        printMap(breakdownByYear.visitSchool(school), school.getName() + " breakdown by year example");
        printMap(breakdownByMajor.visitSchool(school), school.getName() + " breakdown by major example");
        breakdownByMajor.clear_visited();
        breakdownByYear.clear_visited();


        
        



    }
}
