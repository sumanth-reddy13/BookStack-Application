package com.example.student_management_system.Dto;

public class StudentUpdateMobRequestDto {

    // to update student mobile Number.
    private int id;
    private String mobileNumber;

    public StudentUpdateMobRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
