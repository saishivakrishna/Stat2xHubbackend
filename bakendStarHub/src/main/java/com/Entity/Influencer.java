package com.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Influencer {
     @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	    private Long id;

    private String referralCode;
    private String name;
    private String phone;
    private String email;
    private int followers;
    private String instagram;
    private String youtube;
    private String state;
    private String district;
    private String zipcode;
    private String platform;
    private String category;

	public String getReferralCode() {
		return referralCode;
	}
	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Influencer( String referralCode, String name, String phone, String email, int followers,
			String instagram, String youtube, String state, String district, String zipcode, String platform,
			String category) {
		super();
		
		this.referralCode = referralCode;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.followers = followers;
		this.instagram = instagram;
		this.youtube = youtube;
		this.state = state;
		this.district = district;
		this.zipcode = zipcode;
		this.platform = platform;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Influencer [id=" + id + ", referralCode=" + referralCode + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", followers=" + followers + ", instagram=" + instagram + ", youtube=" + youtube
				+ ", state=" + state + ", district=" + district + ", zipcode=" + zipcode + ", platform=" + platform
				+ ", category=" + category + "]";
	}
    
    
    
    
}
