package com.senla.javadbtask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class EmployeeDto {

    private Integer id;
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private Integer birthYear;
    private Integer employmentYear;

    private String address;

    public EmployeeDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getEmploymentYear() {
        return employmentYear;
    }

    public void setEmploymentYear(Integer employmentYear) {
        this.employmentYear = employmentYear;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
