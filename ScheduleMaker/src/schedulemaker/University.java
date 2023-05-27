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

public class University {
    private String uniName;
    private String uniID;
    private String uniAddress;
    private List<Student> students;
    private List<Faculty> faculties;

    public University(String uniName, String uniID, String uniAddress) {
        this.uniName = uniName;
        this.uniID = uniID;
        this.uniAddress = uniAddress;
        this.students = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Getters and setters
    // ...
}

