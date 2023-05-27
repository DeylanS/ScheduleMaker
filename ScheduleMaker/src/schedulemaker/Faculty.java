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

public class Faculty {
    private String facultyID;
    private String facultyName;
    private List<Room> rooms;
    private List<Course> courses;

    public Faculty(String facultyID, String facultyName) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
        this.rooms = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    // Getters and setters
    // ...
}

