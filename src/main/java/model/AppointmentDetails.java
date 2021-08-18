package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentDetails {
    private int id;
    private String pesel;
    private String firstName;
    private String lastName;
    private String drLastName;
    private String room;
    private LocalDateTime dateTime;

    public AppointmentDetails() {
    }

    public AppointmentDetails(int id, String pesel, String firstName, String lastName, String drLastName, String room, LocalDateTime dateTime) {
        this.id = id;
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.drLastName = drLastName;
        this.room = room;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDrLastName() {
        return drLastName;
    }

    public void setDrLastName(String drLastName) {
        this.drLastName = drLastName;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        String dateTimeString = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        StringBuilder stringBuilder = new StringBuilder("                                                                           ");
        stringBuilder.insert(0, "nr: " + id);
        stringBuilder.insert(8, "| " + dateTimeString);
        stringBuilder.insert(27, "| " + (pesel != null ? pesel : ""));
        stringBuilder.insert(41, "| " + (firstName != null ? firstName : "") + ' ' + (lastName!= null ? lastName : ""));
        stringBuilder.insert(80, "| dr " + drLastName);
        stringBuilder.insert(110, "| p. " + room);

        return stringBuilder.toString();
    }
}
