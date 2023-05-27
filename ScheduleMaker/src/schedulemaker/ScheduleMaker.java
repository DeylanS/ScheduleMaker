/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schedulemaker;

/**
 *
 * @author Personal
 */
import java.util.Scanner;

public class ScheduleMaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a University
        System.out.println("Enter university details:");
        System.out.print("University Name: ");
        String uniName = scanner.nextLine();
        System.out.print("University ID: ");
        String uniID = scanner.nextLine();
        System.out.print("University Address: ");
        String uniAddress = scanner.nextLine();
        University university = new University(uniName, uniID, uniAddress);

        // Create Faculties
        System.out.println("\nEnter faculty details:");
        System.out.print("Faculty ID: ");
        String facultyID = scanner.nextLine();
        System.out.print("Faculty Name: ");
        String facultyName = scanner.nextLine();
        Faculty faculty = new Faculty(facultyID, facultyName);
        university.addFaculty(faculty);

        // Create Students
        System.out.println("\nEnter student details:");
        System.out.print("Matric ID: ");
        String matricID = scanner.nextLine();
        System.out.print("Student Name: ");
        String studName = scanner.nextLine();
        System.out.print("Student Email: ");
        String studEmail = scanner.nextLine();
        Student student = new Student(matricID, studName, studEmail, faculty);
        university.addStudent(student);

        // Create Rooms
        System.out.println("\nEnter room details:");
        System.out.print("Room ID: ");
        String roomID = scanner.nextLine();
        System.out.print("Room Name: ");
        String roomName = scanner.nextLine();
        Room room = new Room(roomID, roomName);
        faculty.addRoom(room);

        // Create Sections
        System.out.println("\nEnter section details:");
        System.out.print("Section ID: ");
        String sectionID = scanner.nextLine();
        System.out.print("Section Name: ");
        String sectionName = scanner.nextLine();
        Section section = new Section(sectionID, sectionName, room);

        // Add Course to Faculty and Student
        System.out.println("\nEnter course details:");
        System.out.print("Course ID: ");
        String courseID = scanner.nextLine();
        System.out.print("Course Name: ");
        String courseName = scanner.nextLine();
        Course course = new Course(courseID, courseName);
        faculty.addCourse(course);
        student.addCourse(course);

        // Print the schedule
        System.out.println("\nUniversity: " + university.getUniName());
        System.out.println("Faculty: " + faculty.getFacultyName());
        System.out.println("Student: " + student.getStudName());
        System.out.println("Courses:");
        for (Course studentCourse : student.getCourses()) {
            System.out.println("- " + studentCourse.getCourseName());
        }
        System.out.println("Room: " + room.getRoomName());
        System.out.println("Section: " + section.getSectionName());
    }
}

