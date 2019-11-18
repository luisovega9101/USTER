package com.framework.uster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.framework.uster.entity.Vehicles;

public class VehiclesDAOImpl {
	
	private CConnection cc = new CConnection();
	private Connection cn = null;
	
	public ArrayList<Vehicles> getVehicles() {
		ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>();		
		try {
			String query = "select * from vehicles";
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Vehicles v = new Vehicles();
				v.setId(resultSet.getLong("id"));
				v.setBrand(resultSet.getString("brand"));
				v.setModel(resultSet.getString("model"));
				v.setPlate(resultSet.getString("plate"));
				v.setLicenseRequired(resultSet.getString("licenserequired"));
				vehicles.add(v);			
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return vehicles;
	}
	
	public boolean existVehicle(Vehicles v) {
		boolean exist = false;
		try {			  				
			String query = "Select * from vehicles where brand='"+v.getBrand()+"' and model='"+v.getModel()
						+"' and plate='"+v.getPlate()+"' and licenseRequired='"+v.getLicenseRequired()+"'";
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);			
			ResultSet resultSet = ps.executeQuery();
			
			if (resultSet.next() == false) {
				exist = false;
			} else {
				exist = true;				
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return exist;
	}
	
	public boolean existVehicle(Vehicles v, int id) {
		boolean exist = false;
		try {			  				
			String query = "Select * from vehicles where brand='"+v.getBrand()+"' and model='"+v.getModel()
						+"' and plate='"+v.getPlate()+"' and licenseRequired='"+v.getLicenseRequired()+"' and id!="+id;
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);			
			ResultSet resultSet = ps.executeQuery();
			
			if (resultSet.next() == false) {
				exist = false;
			} else {
				exist = true;				
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return exist;
	}
	
	public void insertVehicles(Vehicles v) {
		try {			  				
			String query = "INSERT INTO vehicles(brand, model, plate, licenseRequired)"
					+ " VALUES (?, ?, ?, ?)";
			cn = cc.getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);
			stmt.setString(1,v.getBrand());
			stmt.setString(2,v.getModel());
			stmt.setString(3,v.getPlate());
			stmt.setString(4,v.getLicenseRequired());
			
			stmt.executeUpdate();
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
	}
	
	public Vehicles getVehicleID(int id) {
		Vehicles v = new Vehicles();
		try {
			String query = "select * from vehicles where id="+id;
			cn = cc.getConnection();
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {				
				v.setId(resultSet.getLong("id"));
				v.setBrand(resultSet.getString("brand"));
				v.setModel(resultSet.getString("model"));
				v.setPlate(resultSet.getString("plate"));
				v.setLicenseRequired(resultSet.getString("licenserequired"));					
			}
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
		return v;
	}

	public void updateVehicles(Vehicles v, int id) {
		try {			  				
			String query = "UPDATE vehicles set brand=?, model=?, plate=?, licenseRequired=? Where id="+id;
			cn = cc.getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);
			stmt.setString(1,v.getBrand());
			stmt.setString(2,v.getModel());
			stmt.setString(3,v.getPlate());
			stmt.setString(4,v.getLicenseRequired());
			
			stmt.executeUpdate();
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
	}
	
	public void deleteVehicles(int id) {
		try {		
			String query = "DELETE from trip where vehiclesid="+id;
			cn = cc.getConnection();
			PreparedStatement stmt = cn.prepareStatement(query);			
			stmt.executeUpdate();
			
			query = "DELETE from vehicles Where id="+id;
			stmt = cn.prepareStatement(query);			
			stmt.executeUpdate();
		} catch (Exception error) {
			System.out.println(error.toString());
		} finally {
			try {
				cn.close();
			} catch (SQLException error) {
				System.out.println("Error Connect :" + error.toString());
			}
		}
	}
}
