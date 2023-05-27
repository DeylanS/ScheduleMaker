/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schedulemaker;

/**
 *
 * @author Personal
 */
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String matricID;
    private String studName;
    private String studEmail;
    private Faculty faculty;
    private List<Course> courses;

    public Student(String matricID, String studName, String studEmail, Faculty faculty) {
        this.matricID = matricID;
        this.studName = studName;
        this.studEmail = studEmail;
        this.faculty = faculty;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    // Getters and setters
    // ...
}

