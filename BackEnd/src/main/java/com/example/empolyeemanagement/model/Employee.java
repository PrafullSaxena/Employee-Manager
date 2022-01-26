package com.example.empolyeemanagement.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imgURL;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee() {
    }

    public Employee(String name,
                    String email,
                    String jobTitle,
                    String phone,
                    String imgURL,
                    String employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imgURL = imgURL;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
