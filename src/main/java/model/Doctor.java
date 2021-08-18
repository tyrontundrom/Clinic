package model;


import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "doctors")
//@NamedQueries({
//        @NamedQuery(name = "getAll", query = "select e from Doctors"),
//        @NamedQuery(name = "getId", query = "select e from Doctors e"),
//        @NamedQuery(name = "getFirstName", query = "select e from Doctors e"),
//        @NamedQuery(name = "getLastName", query = "select e from Doctors e"),
//        @NamedQuery(name = "getSpecialization", query = "select e from Doctors e"),
//        @NamedQuery(name = "getRoom", query = "select e from Doctors e"),
//})
public class Doctor {
    public static final String GET_ALL = "getAll";

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "specialization")
    private String specializations;
    @Column(name = "room")
    private String room;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String specializations, String room) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specializations = specializations;
        this.room = room;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public int getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecializations() {
        return specializations;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "ID: " + id + ": " + firstName + ' ' + lastName + " : "
                + (specializations != null ? specializations + " : " : "") + "p. " + room ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(firstName, doctor.firstName) && Objects.equals(lastName, doctor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
