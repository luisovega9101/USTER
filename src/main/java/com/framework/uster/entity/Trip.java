package com.framework.uster.entity;

import java.sql.Date;

public class Trip {

	private Long id;
	private Vehicles vehicle;
	private Drivers driver;
	private Date date;
	
	public Trip() {
		// TODO Auto-generated constructor stub
	}

	public Trip(Long id, Vehicles vehicle, Drivers driver, Date date) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.driver = driver;
		this.date = date;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	public Drivers getDriver() {
		return driver;
	}

	public void setDriver(Drivers driver) {
		this.driver = driver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
