package model;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @Column(name = "pesel")
    private String pesel;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Appointment> appointments;

    public Client() {
    }

    public Client(String pesel, String firstName, String lastName, String city, String street, String streetNumber, String phone) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
        this.phone = phone;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "[Client: " + pesel + " : " + firstName + ' ' + lastName + " : " + city + ' ' + street + ' ' + streetNumber + " : " + phone + ']';
    }

}
