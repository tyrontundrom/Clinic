package model;


import java.util.ArrayList;
import java.util.List;

public class ClientDTO {
    private String pesel;
    private String firstName;
    private String lastName;
    private String city;
    private String street;
    private String streetNumber;
    private String phone;

    public ClientDTO() {
    }

    public ClientDTO(String pesel, String firstName, String lastName, String city, String street, String streetNumber, String phone) {
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

    public boolean checkPesel(String peselUser, List<String> peselDatabase) {
        boolean boolPesel = false;
        for (int i = 0; i < peselDatabase.size(); i++) {
            if ((peselDatabase.get(i).equals(peselUser))) {
                boolPesel = true;
                System.out.println("Klient o podanym peselu już istnieje");
            }
        }
        return boolPesel;
    }

}
