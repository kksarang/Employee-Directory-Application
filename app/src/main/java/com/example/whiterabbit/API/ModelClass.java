package com.example.whiterabbit.API;

public class ModelClass {

    private int id;
    private String name;
    private String userName;
    private String companyName;
    private double phone;
    private String email;
    private String address;
    private String website;
    private String companyDetails;
    private String image;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(String companyDetails) {
        this.companyDetails = companyDetails;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public ModelClass(int id, String name, String userName, String companyName, double phone, String email, String address, String website, String companyDetails, String image) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.website = website;
        this.companyDetails = companyDetails;
        this.image = image;
    }



}
