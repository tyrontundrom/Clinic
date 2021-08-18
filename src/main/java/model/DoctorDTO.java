package model;

public class DoctorDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String specializations;
    private String room;

    public DoctorDTO() {
    }

    public DoctorDTO(String firstName, String lastName, String specializations, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specializations = specializations;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
