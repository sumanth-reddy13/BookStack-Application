package com.example.student_management_system.Models;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "student_name")
    private String name;
    @Column(name = "student_mobile")
    private String mobile;
    @Column(name = "student_email", unique = true)
    private String email;
    private String country;
    @Column(name = "uid", unique = true)
    private String adharCard;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)  // Bidirectional mapping with Card Entity.
    private Card card;             // mappedBy = "student" object of parent class foreign Key.

    public Student() {

    }

    public Student(int id, String name, String mobile, String email, String country, Card card, String adharCard) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.country = country;
        this.card = card;
        this.adharCard = adharCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getAdharCard() {
        return adharCard;
    }

    public void setAdharCard(String adharCard) {
        this.adharCard = adharCard;
    }
}
