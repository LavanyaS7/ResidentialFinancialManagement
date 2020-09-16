package com.SocietyFinancialManagement.sfm.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Details {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int detail_id;
	private String door_no;
	private String date; 
	private String userName;
	private int parking_charges;
	private int Monthly_Maintenance;
	private int Total_Amount;
	
	public Details() {
	}
	
	public Details(String name, int parking_charges, int monthly_Maintenance, int total_Amount) {
		super();
		this.userName = name;
		this.parking_charges = parking_charges;
		Monthly_Maintenance = monthly_Maintenance;
		Total_Amount = total_Amount;
	}

	public int getId() {
		return detail_id;
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public int getParking_charges() {
		return parking_charges;
	}
	public void setParking_charges(int parking_charges) {
		this.parking_charges = parking_charges;
	}
	public int getMonthly_Maintenance() {
		return Monthly_Maintenance;
	}
	public void setMonthly_Maintenance(int monthly_Maintenance) {
		Monthly_Maintenance = monthly_Maintenance;
	}
	public int getTotal_Amount() {
		return Total_Amount;
	}
	public void setTotal_Amount(int total_Amount) {
		Total_Amount = total_Amount;
	}
	public String getDoor_no() {
		return door_no;
	}
	public void setDoor_no(String door_no) {
		this.door_no = door_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
