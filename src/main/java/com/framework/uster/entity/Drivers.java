package com.framework.uster.entity;

public class Drivers {
	
	private Long id;
	private String name;
	private String surname;
	private String license;
	
	public Drivers() {
		// TODO Auto-generated constructor stub
	}
	
	public Drivers(Long id, String name, String surname, String license) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.license = license;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLicense() {
		return this.license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	@Override
	public String toString() {
		String driver = getName() + " " + getSurname();
		return driver;
	}
}
