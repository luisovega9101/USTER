package com.framework.uster.entity;

public class Vehicles {
	
	private Long id;
	private String brand;
	private String model;
	private String plate;
	private String licenseRequired;

	public Vehicles() {
		// TODO Auto-generated constructor stub
	}

	public Vehicles(Long id, String brand, String model, String plate, String licenseRequired) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.plate = plate;
		this.licenseRequired = licenseRequired;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlate() {
		return this.plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getLicenseRequired() {
		return this.licenseRequired;
	}

	public void setLicenseRequired(String licenseRequired) {
		this.licenseRequired = licenseRequired;
	}
	
	@Override
	public String toString() {
		String vehicle = getBrand() + " " + getModel() + " [" + getPlate() + "]";
		return vehicle;
	}

}
