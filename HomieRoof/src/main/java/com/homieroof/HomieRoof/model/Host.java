package com.homieroof.HomieRoof.model;

import java.util.ArrayList;	
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long HostId;

	private String hostName;
	private String homeName;
	private String phoneNo;
	private String pics;
	private int rooms;
	private String foodDetails;
	private String email;
	private String price;
	private String noOfFamilyMembersMale;
	private String noOfFamilyMembersFemale;
	private String username;
	private String password;
	private String hostAddress;
	private int persons;

	

	@OneToMany(targetEntity = Availability.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "HostId")
	private List<Availability> u = new ArrayList<Availability>();

	public void add(Availability avalability) {
		this.u.add(avalability);
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHomeName() {
		return homeName;
	}

	public void setHomeName(String homeName) {
		this.homeName = homeName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	public String getFoodDetails() {
		return foodDetails;
	}

	public void setFoodDetails(String foodDetails) {
		this.foodDetails = foodDetails;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNoOfFamilyMembersMale() {
		return noOfFamilyMembersMale;
	}

	public void setNoOfFamilyMembersMale(String noOfFamilyMembersMale) {
		this.noOfFamilyMembersMale = noOfFamilyMembersMale;
	}

	public String getNoOfFamilyMembersFemale() {
		return noOfFamilyMembersFemale;
	}

	public void setNoOfFamilyMembersFemale(String noOfFamilyMembersFemale) {
		this.noOfFamilyMembersFemale = noOfFamilyMembersFemale;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getHostId() {
		return HostId;
	}

	public void setHostId(Long hostId) {
		HostId = hostId;
	}

	public String gethostAddress() {
		return hostAddress;
	}

	public void sethostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public int getPersons() {
		return persons;
	}

	public void setPersons(int persons) {
		this.persons = persons;
	}

}
