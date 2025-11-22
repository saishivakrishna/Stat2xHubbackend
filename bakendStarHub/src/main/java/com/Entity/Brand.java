package com.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;
    private String owner;
    private String email;
    private String phone;
    private String state;
    private String district;
    private String pincode;
    private String landmark;
    private String website;
    private String aboutProduct;

    public Brand() {
    }

    public Brand(Long id, String brandName, String owner, String email, String phone,
                 String state, String district, String pincode, String landmark,
                 String website, String aboutProduct) {
        this.id = id;
        this.brandName = brandName;
        this.owner = owner;
        this.email = email;
        this.phone = phone;
        this.state = state;
        this.district = district;
        this.pincode = pincode;
        this.landmark = landmark;
        this.website = website;
        this.aboutProduct = aboutProduct;
    }

    // ⭐ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrandName() { return brandName; }
    public void setBrandName(String brandName) { this.brandName = brandName; }

    public String getOwner() { return owner; }
    public void setOwner(String owner) { this.owner = owner; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getPincode() { return pincode; }
    public void setPincode(String pincode) { this.pincode = pincode; }

    public String getLandmark() { return landmark; }
    public void setLandmark(String landmark) { this.landmark = landmark; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getAboutProduct() { return aboutProduct; }
    public void setAboutProduct(String aboutProduct) { this.aboutProduct = aboutProduct; }
}
