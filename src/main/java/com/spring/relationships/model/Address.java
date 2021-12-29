package com.spring.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String houseNo;
    private String streetAddress;
    private String district;
    private String city;
    private String country;
    private int zipCode;
    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Student student;

    public Address() {
    }

    public Address(Long id,
                   String houseNo,
                   String streetAddress,
                   String district,
                   String city,
                   String country,
                   int zipCode,
                   Student student) {
        this.id = id;
        this.houseNo = houseNo;
        this.streetAddress = streetAddress;
        this.district = district;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
