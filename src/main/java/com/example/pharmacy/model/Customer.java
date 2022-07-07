package com.example.pharmacy.model;

public class Customer {
    public long id;
    public String name;
    public String email;
    public String medicine;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMedicine() {
        return medicine;
    }
    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }


}
