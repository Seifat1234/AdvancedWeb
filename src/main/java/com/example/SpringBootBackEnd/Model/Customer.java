package com.example.SpringBootBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Medicine")
    private String Medicine;


    public Customer() {
    }


    public Customer(long id, String name, String email, String medicine) {
        this.id = id;
        Name = name;
        Email = email;
        Medicine = medicine;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return Name;
    }


    public void setName(String name) {
        Name = name;
    }


    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }


    public String getMedicine() {
        return Medicine;
    }


    public void setMedicine(String medicine) {
        Medicine = medicine;
    }

    
}
