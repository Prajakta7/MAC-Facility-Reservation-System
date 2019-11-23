package com.pshashank.facilitiesmanagement.POJO;

public class User {

    String FName;
    String LName;
    String UTAID;
    String Phone;
    String Email;
    String Address;
    String City;
    String State;
    String Zip;

    public String getFName() {
        return FName;
    }

    public String getLName() {
        return LName;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getZip() {
        return Zip;
    }

    public String getUTAID() {
        return UTAID;
    }

    public void setUTAID(String UTAID) {
        this.UTAID = UTAID;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setState(String state) {
        State = state;
    }

    public void setZip(String zip) {
        Zip = zip;
    }
}
