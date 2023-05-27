/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package schedulemaker;

/**
 *
 * @author Personal
 */
public interface Room {
    private String roomID;
    private String roomName;

    public Room(String roomID, String roomName) {
        this.roomID = roomID;
        this.roomName = roomName;
    }

    // Getters and setters
    // ...
}
