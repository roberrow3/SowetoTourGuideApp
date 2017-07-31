package com.example.admin.sowetotourguideapp;

/**
 * Created by Admin on 7/28/2017.
 */

public class Schools {

    String schoolId;
    String schoolName;
    String schoolAddress;


    public Schools() {

    }

    public Schools(String schoolId, String schoolName, String schoolAddress) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;

    }

    public String getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;

    }
}
